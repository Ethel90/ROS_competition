package com.example.ros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
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

    private void buildViews() {
        final Button btGuide;
        final Button btActivity;
        final Button btDiscount;

        btGuide = (Button) findViewById(R.id.btGuide);
        btActivity = (Button) findViewById(R.id.btActivity);
        btDiscount = (Button) findViewById(R.id.btDiscount);

        btGuide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Location.class);
                startActivity(intent);
            }
        });

        btActivity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Event.class);
                startActivity(intent);
            }
        });

        btDiscount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Discount.class);
                startActivity(intent);
            }
        });
    }
}
