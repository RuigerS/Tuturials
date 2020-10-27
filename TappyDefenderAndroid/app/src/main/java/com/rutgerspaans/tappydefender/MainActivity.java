package com.rutgerspaans.tappydefender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonPlay=(Button)findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        TextView textHigh=(TextView)findViewById((R.id.textHighScore));
        textHigh.setText(" "+android.os.Build.VERSION.SDK_INT);

    }

    @Override
    public void onClick(View v) {
    Intent i=new Intent(this,GameActivity.class);
    startActivity(i);
    finish();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            finish();
            return true;
        }
        return false;
    }
}