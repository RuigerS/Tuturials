package com.rutgerspaans.snake;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowInsets;
import android.view.WindowMetrics;

public class MainActivity extends Activity {
    Canvas canvas;
    SnakeAnimView snakeAnimView;
    Bitmap headAnimBitmap;
    Rect rectToBeDrawn;
    int frameHeight = 64;
    int frameWidth = 64;
    int numFrames = 6;
    int frameNumber;

    int screenWidth;
    int screenHeight;

    long lastFrameTime;
    int fps;
    int hi;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Find window metrics, height and width
        WindowMetrics metrics = getWindowManager().getCurrentWindowMetrics();
        WindowInsets windowInsets = metrics.getWindowInsets();
        Insets insets = windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
        //Insets, taking up space like navigationbar etc
        int insetsWidth = insets.right + insets.left;
        int insetsHeight = insets.top + insets.bottom;
        //Size of the screen
        Rect bounds = metrics.getBounds();
        screenWidth = bounds.width() - insetsWidth;
        screenHeight = bounds.height() - insetsHeight;
        //End find metrics screen

        headAnimBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.head_sprite_sheet);
        snakeAnimView = new SnakeAnimView(this);
        setContentView(snakeAnimView);
        i = new Intent(this, GameActivity.class);
    }

    class SnakeAnimView extends SurfaceView implements Runnable {
        Thread ourThread = null;
        SurfaceHolder ourHolder;
        volatile boolean playingSnake;
        Paint paint;

        public SnakeAnimView(Context context) {
            super(context);
            ourHolder = getHolder();
            paint = new Paint();
            frameWidth = headAnimBitmap.getWidth() / numFrames;
            frameHeight = headAnimBitmap.getHeight();
        }

        @Override
        public void run() {
            while (playingSnake) {
                updateSnake();
                drawSnake();
                controlFPSSnake();
            }
        }

        public void updateSnake() {
            rectToBeDrawn = new Rect((frameNumber * frameWidth) - 1, 0, (frameNumber * frameWidth + frameWidth) - 1, frameHeight);
            frameNumber += 1;
            if (frameNumber == numFrames) {
                frameNumber = 0;
            }
        }

        public void drawSnake() {
            if (ourHolder.getSurface().isValid()) {
                canvas = ourHolder.lockCanvas();
                paint = new Paint();
                canvas.drawColor(Color.BLACK);
                paint.setColor(Color.argb(255, 255, 255, 255));
                paint.setTextSize(25);
                canvas.drawText("Hi Score: " + hi, 10, screenHeight - 50, paint);
                Rect destRect = new Rect(screenWidth / 2 - 100, screenHeight / 2 - 100, screenWidth / 2 + 100, screenHeight / 2 + 100);
                canvas.drawBitmap(headAnimBitmap, rectToBeDrawn, destRect, paint);
                ourHolder.unlockCanvasAndPost(canvas);
            }
        }

        public void controlFPSSnake() {
            long timeThisFrame = (System.currentTimeMillis() - lastFrameTime);
            long timeToSleep = 500 - timeThisFrame;
            if (timeThisFrame > 0) {
                fps = (int) (1000 / timeThisFrame);
            }
            if (timeToSleep > 0) {
                try {
                    ourThread.sleep(timeToSleep);
                } catch (InterruptedException e) {
                    //Nothing to see here
                }
            }
            lastFrameTime = System.currentTimeMillis();
        }

        public void pause() {
            playingSnake = false;
            try {
                ourThread.join();
            } catch (InterruptedException e) {
                //Nothing to see here, move along...
            }
        }

        public void resume() {
            playingSnake = true;
            ourThread = new Thread(this);
            ourThread.start();
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {
            startActivity(i);
            return true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        snakeAnimView.pause();
        finish();
    }
    @Override
    protected void onResume(){
        super.onResume();
        snakeAnimView.resume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        snakeAnimView.pause();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            snakeAnimView.pause();
            finish();
            return true;
        }
        return false;
    }
}