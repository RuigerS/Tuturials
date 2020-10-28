package com.rutgerspaans.Asteroids;

import android.app.Activity;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowInsets;
import android.view.WindowMetrics;

public class AsteroidsActivity extends Activity {
    private GLSurfaceView asteroidsView;
    int screenWidth;
    int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureDisplay();
        asteroidsView = new AsteroidsView(this, screenWidth, screenHeight);
        setContentView(asteroidsView);
    }

    public void configureDisplay() {
        if (android.os.Build.VERSION.SDK_INT < 30) {
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
            screenHeight = size.y;
        } else {
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
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        asteroidsView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        asteroidsView.onResume();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }
        return false;
    }
}