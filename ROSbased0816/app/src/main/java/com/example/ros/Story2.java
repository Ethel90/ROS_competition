package com.example.ros;

import android.os.Bundle;
import android.view.View;

public class Story2 extends Page {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story2);
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
        final View S2T;

        S2T = (View) findViewById(R.id.story2_touch);

        S2T.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Story2.super.SwitchPage(Game.class);
                finish();
            }
        });
    }
}