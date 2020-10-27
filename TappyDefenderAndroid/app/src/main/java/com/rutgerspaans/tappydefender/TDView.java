package com.rutgerspaans.tappydefender;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TDView extends SurfaceView implements Runnable {
    volatile boolean playing;
    Thread gameThread = null;
    private PlayerShip player;
    public EnemyShip enemy1;
    public EnemyShip enemy2;
    public EnemyShip enemy3;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder ourHolder;
    public ArrayList<SpaceDust> dustList = new ArrayList<SpaceDust>();
    long nextTime;
    private float distanceRemaining;
    private long timeTaken;
    private long timeStarted;
    private long fastestTime;
    private int screenX;
    private int screenY;
    private Context context;
    private boolean gameEnded;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public TDView(Context context, int screenX, int screenY) {
        super(context);
        this.context = context;
        this.screenX = screenX;
        this.screenY = screenY;
        ourHolder = getHolder();
        paint = new Paint();
        prefs = context.getSharedPreferences("HiScores", context.MODE_PRIVATE);
        editor = prefs.edit();
        fastestTime = prefs.getLong("fastestTime", 1000000);
        startGame();
    }

    private void startGame() {
        player = new PlayerShip(context, screenX, screenY);
        enemy1 = new EnemyShip(context, screenX, screenY);
        enemy2 = new EnemyShip(context, screenX, screenY);
        enemy3 = new EnemyShip(context, screenX, screenY);
        int numSpecs = 40;
        for (int i = 0; i < numSpecs; i++) {
            SpaceDust spec = new SpaceDust(screenX, screenY);
            dustList.add(spec);
        }
        distanceRemaining = 10000;
        timeTaken = 0;
        timeStarted = System.currentTimeMillis();
        gameEnded = false;
    }

    @Override
    public void run() {
        while (playing) {
            update();
            draw();
            control();
        }
    }

    private void update() {
        boolean hitDetected = false;
        if (Rect.intersects
                (player.getHitbox(), enemy1.getHitbox())) {
            enemy1.setX(-200);
            hitDetected = true;
        }

        if (Rect.intersects
                (player.getHitbox(), enemy2.getHitbox())) {
            enemy2.setX(-200);
            hitDetected = true;
        }

        if (Rect.intersects
                (player.getHitbox(), enemy3.getHitbox())) {
            enemy3.setX(-200);
            hitDetected = true;
        }
        if (hitDetected) {
            player.reduceShieldStrength();
            if (player.getShieldStrength() < 0) {
                gameEnded = true;
            }
        }
        player.update();
        enemy1.update(player.getSpeed());
        enemy2.update(player.getSpeed());
        enemy3.update(player.getSpeed());
        for (SpaceDust sd : dustList) {
            sd.update(player.getSpeed());
        }
        if (!gameEnded) {
            distanceRemaining -= player.getSpeed();
            timeTaken = System.currentTimeMillis() - timeStarted;
        }
        if (distanceRemaining <= 0) {
            if (timeTaken < fastestTime) {
                fastestTime = timeTaken;
                editor.putLong("fastestTime", fastestTime);
                editor.commit();
            }
            distanceRemaining = 0;
            gameEnded = true;
        }
    }


    private void draw() {
        if (ourHolder.getSurface().isValid()) {
            canvas = ourHolder.lockCanvas();
            canvas.drawColor(Color.argb(255, 0, 0, 0));
            canvas.drawBitmap(
                    player.getBitmap(),
                    player.getX(),
                    player.getY(),
                    paint);
            canvas.drawBitmap(
                    enemy1.getBitmap(),
                    enemy1.getX(),
                    enemy1.getY(), paint);

            canvas.drawBitmap(
                    enemy2.getBitmap(),
                    enemy2.getX(),
                    enemy2.getY(), paint);

            canvas.drawBitmap(
                    enemy3.getBitmap(),
                    enemy3.getX(),
                    enemy3.getY(), paint);
            paint.setColor(Color.argb(255, 255, 255, 255));
            for (SpaceDust sd : dustList) {
                canvas.drawPoint(sd.getX(), sd.getY(), paint);
            }
            if (!gameEnded) {
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setColor(Color.argb(255, 255, 255, 255));
                paint.setTextSize(screenY / 25);
                canvas.drawText("Fastest: " + fastestTime + "ms", 10, screenY / 25 + 10, paint);
                canvas.drawText("Time: " + timeTaken + "ms", screenX / 3, screenY / 25 + 10, paint);
                canvas.drawText("Distance: " + distanceRemaining + " KM", screenX / 3, screenY - 20, paint);
                canvas.drawText("Shield: " + player.getShieldStrength(), 10, screenY - 20, paint);
                canvas.drawText("Speed: " + player.getSpeed() * 60 + " KMS", (screenX / 3) * 2, screenY - 20, paint);
            } else {
                paint.setTextSize(screenY / 10);
                paint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("GAME OVER", screenX / 2, screenY / 10, paint);
                paint.setTextSize(screenY / 25);
                if (fastestTime == timeTaken) {
                    canvas.drawText("Time: NEW HIGHSCORE " + timeTaken + "ms", screenX / 2, screenY / 10 + screenY / 25 * 2, paint);
                    canvas.drawText("Fastest: " + fastestTime + "ms", screenX / 2, screenY / 10 + screenY / 25 * 4, paint);
                } else {
                    canvas.drawText("Time: " + timeTaken + "ms", screenX / 2, screenY / 10 + screenY / 25 * 2, paint);
                    canvas.drawText("Fastest: " + fastestTime + "ms", screenX / 2, screenY / 10 + screenY / 25 * 4, paint);
                }
                canvas.drawText("Distance remaining: " + distanceRemaining / 1000 + " KM", screenX / 2, screenY / 10 + screenY / 25 * 6, paint);
                paint.setTextSize(screenY / 12);
                canvas.drawText("Tap to replay!", screenX / 2, screenY / 10 + screenY / 25 * 6 + screenY / 12 * 2, paint);
            }
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }


    private void control() {
        try {
            gameThread.sleep(17);
            nextTime = System.currentTimeMillis() + 17;
        } catch (InterruptedException e) {

        }
    }


    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {

        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                player.stopBoosting();
                break;
            case MotionEvent.ACTION_DOWN:
                player.setBoosting();
                if (gameEnded) {
                    startGame();
                }
                break;
        }
        return true;
    }
}
