package com.isf.todov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActiviy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activiy);
        getSupportActionBar().hide(); // hiding the activity
//
        final Intent intent = new Intent(SplashActiviy.this, MainActivity.class); //launchin my main activity
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },1000); // this created a delay when launching the mainactivity
    }
}