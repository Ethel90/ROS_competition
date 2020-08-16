package com.example.ros;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Discount extends Page {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discount);
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

    private  void buildViews() {
        final Class nextPage = MainActivity.class;

        final Button btBrand;
        final Button btGame;
        final Button btBack;
        final Button btHome;

        btBrand = (Button) findViewById(R.id.btBrand);
        btGame = (Button) findViewById(R.id.btGame);
        btBack = (Button)findViewById(R.id.btBack);
        btHome = (Button)findViewById(R.id.btHome);

        btBrand.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Discount.super.SwitchPage(nextPage);
            }
        });

        btGame.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Discount.super.SwitchPage(Story.class);
                finish();
            }
        });

        btBack.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Discount.super.LastPage();
            }
        });

        btHome.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Discount.super.HomePage();
            }
        });
    }
}
