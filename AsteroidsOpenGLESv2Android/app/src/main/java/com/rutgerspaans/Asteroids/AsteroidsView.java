package com.rutgerspaans.Asteroids;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class AsteroidsView extends GLSurfaceView {
    GameManager gm;
    private InputController ic;

    public AsteroidsView(Context context, int screenX, int screenY){
        super(context);
        ic = new InputController(screenX, screenY);
        gm=new GameManager(screenX,screenY);
        setEGLContextClientVersion(2);
        setRenderer(new AsteroidsRenderer(gm,ic));
    }
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ic.handleInput(motionEvent, gm);
        return true;
    }
}
