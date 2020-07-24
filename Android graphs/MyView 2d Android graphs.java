package com.bennyplo.graphics2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.view.View;

/**
 * Created by benlo on 09/05/2018.
 */

public class MyView extends View {
    private Paint redPaint;
    private Paint redFillPaint;
    private Paint bluePaint;
    private Paint greenPaint;
    private Paint blackPaint;
    private Path pathWay1;
    private Path pathWay2;
    private LinearGradient linear;
    private Paint gradientPaint;



    public MyView(Context context) {
        super(context, null);
        //Add your initialisation code here
        redPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint.setStyle(Paint.Style.STROKE);//stroke only no fill
        redPaint.setColor(0xffff0000);//color red
        redPaint.setStrokeWidth(5);//set the line stroke width to 5

        bluePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        bluePaint.setStyle(Paint.Style.STROKE);//stroke only no fill
        bluePaint.setColor(0xff0000ff);//color blue
        bluePaint.setStrokeWidth(5);//set the line stroke width to 5

        greenPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        greenPaint.setStyle(Paint.Style.STROKE);//stroke only no fill
        greenPaint.setARGB(255,0,255,0);

        pathWay1=new Path();
        pathWay2=new Path();

        redFillPaint=new Paint();
        redFillPaint.setStyle(Paint.Style.FILL);
        redFillPaint.setARGB(255,255,0,0);

        blackPaint=new Paint();
        blackPaint.setStyle(Paint.Style.STROKE);
        blackPaint.setColor(Color.BLACK);

        linear=new LinearGradient(0,0,500,200,Color.BLUE,Color.RED, Shader.TileMode.MIRROR);
        gradientPaint=new Paint();
        gradientPaint.setStyle(Paint.Style.FILL);
        gradientPaint.setShader(linear);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Add your drawing code here
//        canvas.drawRect(10,30,200,200,redPaint);
//        canvas.drawCircle(300,300,250,bluePaint);
//        canvas.drawCircle(500,450,50,bluePaint);
//        canvas.drawRect(500,500,700,700,redPaint);
//        canvas.drawCircle(600,600,145,bluePaint);

        pathWay2.moveTo(50,300);
        pathWay2.lineTo(160,280);
        pathWay2.lineTo(300,380);
        pathWay2.lineTo(380,370);
        pathWay2.lineTo(280,450);
        pathWay2.lineTo(100,390);
        pathWay2.lineTo(160,380);
        pathWay2.lineTo(50,300);

        pathWay1.moveTo(100,200);
        pathWay1.lineTo(200,300);
        pathWay1.lineTo(300,250);
        pathWay1.lineTo(400,300);
        pathWay1.lineTo(500,200);
        pathWay1.close();

        canvas.drawPath(pathWay2,redFillPaint);
        canvas.drawPath(pathWay2,blackPaint);

//        canvas.drawPath(pathWay1,gradientPaint);
        //canvas.drawPath(pathWay,greenPaint);
        //canvas.drawCircle((50+160+300+380+280+100+160+50)/8,(300+280+380+370+450+390+380+300)/8,250,bluePaint);
        
    }
}
