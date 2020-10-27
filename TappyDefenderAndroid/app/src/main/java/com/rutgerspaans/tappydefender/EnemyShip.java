package com.rutgerspaans.tappydefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

public class EnemyShip {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 1;
    private int minY;
    private int maxY;
    private int minX;
    private int maxX;
    private Rect hitBox;

    public EnemyShip(Context context, int screenX, int screenY){
        Random generator=new Random();
        int whichBitmap=generator.nextInt(3);
        switch(whichBitmap){
            case 0:
                bitmap = BitmapFactory.decodeResource
                        (context.getResources(), R.drawable.enemy);
                break;
            case 1:
                bitmap = BitmapFactory.decodeResource
                        (context.getResources(), R.drawable.enemy2);
                break;
            case 2:
                bitmap = BitmapFactory.decodeResource
                        (context.getResources(), R.drawable.enemy3);
                break;
        }
        maxX = screenX;
        maxY = screenY-bitmap.getHeight();
        minX = 0;
        minY = 0;
        speed = generator.nextInt(6)+10;
        x = screenX;
        y = generator.nextInt(maxY);
        hitBox = new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void update(int playerSpeed){
        x -= playerSpeed;
        x -= speed;
        if(x < minX-bitmap.getWidth()){
            Random generator = new Random();
            speed = generator.nextInt(10)+10;
            x = maxX;
            y = generator.nextInt(maxY);
        }
        hitBox.left = x;
        hitBox.top = y;
        hitBox.right = x + bitmap.getWidth();
        hitBox.bottom = y + bitmap.getHeight();
    }
    public Rect getHitbox(){
        return hitBox;
    }
    public void setX(int x) {
        this.x = x;
    }
}
