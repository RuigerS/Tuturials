package com.rutgerspaans.mapping2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowInsets;
import android.view.WindowMetrics;

import java.util.Random;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    Canvas canvas;
    SquashCourtView squashCourtView;
    WindowMetrics metrics;
    WindowInsets windowInsets;
    Insets insets;
    Rect bounds;
    int insetsWidth;
    int insetsHeight;
    int screenWidth;
    int screenHeight;
    //Game objects
    int racketWidth;
    int racketHeight;
    Point racketPosition;
    Point ballPosition;
    int racketTargetX;
    boolean oncePoint;
    int ballWidth;
    //for ball movement
    boolean ballIsMovingLeft;
    boolean ballIsMovingRight;
    boolean ballIsMovingUp;
    boolean ballIsMovingDown;
    //for racket movement
    boolean racketIsMovingLeft;
    boolean racketIsMovingRight;
    //stats
    long lastFrameTime;
    int fps;
    int score;
    int lives;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        squashCourtView = new SquashCourtView(this);
        setContentView(squashCourtView);
        metrics = getWindowManager().getCurrentWindowMetrics();
        windowInsets = metrics.getWindowInsets();
        insets = windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
        //Insets, taking up space like navigationbar etc
        insetsWidth = insets.right + insets.left;
        insetsHeight = insets.top + insets.bottom;
        //Size of the screen
        bounds = metrics.getBounds();
        screenWidth = bounds.width() - insetsWidth;
        screenHeight = bounds.height() - insetsHeight;
        Log.e(TAG," IWidth "+insetsWidth + " IHeight "+insetsHeight+ " LegWidth "+screenWidth+ " LegHeight "+screenHeight );
        //The game objects
        racketPosition = new Point();
        racketPosition.x = screenWidth / 2;
        racketTargetX=racketPosition.x;
        racketPosition.y = screenHeight - (screenHeight/90);
        racketWidth = screenWidth / 8;
        racketHeight = screenHeight/180;

        ballWidth = screenWidth / 35;
        ballPosition = new Point();
        ballPosition.x = screenWidth / 2;
        ballPosition.y = 1 + ballWidth;

        lives = 3;
        oncePoint = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        while (true) {
            squashCourtView.pause();
            break;
        }
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        squashCourtView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        squashCourtView.resume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            squashCourtView.pause();
            finish();
            return true;
        }
        return false;
    }

    class SquashCourtView extends SurfaceView implements Runnable {
        Thread ourThread = null;
        SurfaceHolder ourHolder;
        volatile boolean playingSquash;
        Paint paint;
        private static final String TAG = "SquashCourtView";

        public SquashCourtView(Context context) {
            super(context);
            ourHolder = getHolder();
            paint = new Paint();
            ballIsMovingDown = true;
            Log.v(TAG, " SquashCourtView");
            Random rndNo = new Random();
            int ballDirection = rndNo.nextInt(3);
            switch (ballDirection) {
                case 0:
                    ballIsMovingLeft = true;
                    ballIsMovingRight = false;
                    break;
                case 1:
                    ballIsMovingLeft = false;
                    ballIsMovingRight = true;
                    break;
                case 2:
                    ballIsMovingLeft = false;
                    ballIsMovingRight = false;
                    break;
            }
        }

        @Override
        public void run() {
            while (playingSquash) {
                updateCourt();
                drawCourt();
                controlFPS();
            }
        }

        public void updateCourt() {
            if (oncePoint) {
                racketIsMovingRight = false;
                racketIsMovingLeft = false;
                if (racketTargetX < racketPosition.x) {
                    racketIsMovingLeft = true;
                }
                if (racketTargetX > racketPosition.x) {
                    racketIsMovingRight = true;
                }
                if((racketTargetX-racketPosition.x)>=(screenWidth/100) || (racketTargetX-racketPosition.x)<=-(screenWidth/100)) {
                    if (racketIsMovingRight) {
                        racketPosition.x += (screenWidth/100);
                    }
                    if (racketIsMovingLeft) {
                        racketPosition.x -= (screenWidth/100);
                    }
                }else{
                    racketPosition.x=racketTargetX;
                    racketIsMovingRight = false;
                    racketIsMovingLeft = false;
                }

            } else {
                if (racketIsMovingRight) {
                    racketPosition.x += (screenWidth/100);
                }
                if (racketIsMovingLeft) {
                    racketPosition.x -= (screenWidth/100);
                }
            }

            //ball hit right of screen
            if ((ballPosition.x + ballWidth) > screenWidth) {
                ballIsMovingLeft = true;
                ballIsMovingRight = false;
            }
            //ball hit left of screen
            if (ballPosition.x < 0) {
                ballIsMovingLeft = false;
                ballIsMovingRight = true;
            }
            //ball bottom of screen
            if (ballPosition.y > screenHeight - ballWidth) {
                lives -= 1;
                if (lives <= 0) {
                    lives = 3;
                    score = 0;
                }
                ballPosition.y = 1 + ballWidth;
                Random rndNo = new Random();
                int startX = rndNo.nextInt(screenWidth - ballWidth) + 1;
                ballPosition.x = startX + ballWidth;
                int ballDirection = rndNo.nextInt(3);
                switch (ballDirection) {
                    case 0:
                        ballIsMovingLeft = true;
                        ballIsMovingRight = false;
                        break;
                    case 1:
                        ballIsMovingLeft = false;
                        ballIsMovingRight = true;
                        break;
                    case 2:
                        ballIsMovingLeft = false;
                        ballIsMovingRight = false;
                        break;
                }
            }
            //ball top of screen
            if (ballPosition.y <= 0) {
                ballIsMovingDown = true;
                ballIsMovingUp = false;
                ballPosition.y = 1;
            }
            if (ballIsMovingDown) {
                ballPosition.y += 6;
            }
            if (ballIsMovingUp) {
                ballPosition.y -= 10;
            }
            if (ballIsMovingLeft) {
                ballPosition.x -= 12;
            }
            if (ballIsMovingRight) {
                ballPosition.x += 12;
            }
            //ball hit racket
            if ((ballPosition.y + ballWidth) >= (racketPosition.y - racketHeight / 2)) {
                int halfRacket = racketWidth / 2;
                if (((ballPosition.x + ballWidth) > (racketPosition.x - halfRacket))
                        && ((ballPosition.x - ballWidth) < (racketPosition.x + halfRacket))) {
                    score += 1;
                    ballIsMovingUp = true;
                    ballIsMovingDown = false;
                    if (ballPosition.x > racketPosition.x) {
                        ballIsMovingLeft = false;
                        ballIsMovingRight = true;
                    } else {
                        ballIsMovingLeft = true;
                        ballIsMovingRight = false;
                    }
                }
            }
        }

        public void drawCourt() {
            if (ourHolder.getSurface().isValid()) {
                canvas = ourHolder.lockCanvas();
                paint = new Paint();
                canvas.drawColor(Color.BLACK);
                paint.setColor(Color.argb(255, 255, 255, 255));
                paint.setTextSize(45);
                canvas.drawText("Score: " + score + " Lives: " + lives + " FPS: " + fps, 20, 40, paint);
                canvas.drawRect(racketPosition.x - (racketWidth / 2), racketPosition.y - (racketHeight / 2), racketPosition.x + (racketWidth / 2), racketPosition.y + (racketHeight / 2), paint);
                canvas.drawRect(ballPosition.x, ballPosition.y, ballPosition.x + ballWidth, ballPosition.y + ballWidth, paint);
                ourHolder.unlockCanvasAndPost(canvas);
//                Log.e(TAG, " INITIALIZE");

            }
        }

        public void controlFPS() {
            long timeThisFrame = (System.currentTimeMillis() - lastFrameTime);
            long timeToSleep = 15 - timeThisFrame;
            if (timeToSleep < 0) {
                timeToSleep = 0;
            }
            if (timeThisFrame > 0) {
                fps = (int) (1000 / timeThisFrame);
            }
            try {
                ourThread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                //Crickets
            }
            lastFrameTime = System.currentTimeMillis();
        }

        public void pause() {
            playingSquash = false;
            try {
                ourThread.join();
            } catch (InterruptedException e) {
                //Crickets
            }
        }

        public void resume() {
            playingSquash = true;
            ourThread = new Thread(this);
            ourThread.start();
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!oncePoint) {
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        if (motionEvent.getX() >= screenWidth / 2) {
                            racketIsMovingRight = true;
                            racketIsMovingLeft = false;
                        } else {
                            racketIsMovingRight = false;
                            racketIsMovingLeft = true;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        racketIsMovingRight = false;
                        racketIsMovingLeft = false;
                        break;
                }
            } else {
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_UP:
                        racketTargetX = (int) motionEvent.getX();
                        racketIsMovingRight = false;
                        racketIsMovingLeft = false;
                        if (racketTargetX < racketPosition.x) {
                            racketIsMovingLeft = true;
                        }
                        if (racketTargetX > racketPosition.x) {
                            racketIsMovingRight = true;
                        }
                        break;
                }
            }
            return true;
        }
    }
}