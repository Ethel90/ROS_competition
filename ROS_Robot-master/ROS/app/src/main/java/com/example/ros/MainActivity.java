package com.example.ros;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        buildViews();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
    }
    @Override
    public void onStop()
    {
        super.onStop();
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    private void buildViews() {
        final ImageView btGuide;
        final ImageView btActivity;
        final ImageView btDiscount;

        btGuide = (ImageView) findViewById(R.id.btGuide);
        btActivity = (ImageView) findViewById(R.id.btActivity);
        btDiscount = (ImageView) findViewById(R.id.btDiscount);

        ViewCompat.setElevation(btGuide, 30);
        ViewCompat.setElevation(btActivity, 30);
        ViewCompat.setElevation(btDiscount, 30);

        btGuide.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                btGuide.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btanim));
                btGuide.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, Location.class);
                        startActivity(intent);
                    }
                }, 290);
            }
        });

        btActivity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                btActivity.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btanim));
                btActivity.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, Event.class);
                        startActivity(intent);
                    }
                }, 290);
            }
        });

        btDiscount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                btDiscount.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btanim));
                btDiscount.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, Discount.class);
                        startActivity(intent);
                    }
                }, 290);
            }
        });
    }
}
