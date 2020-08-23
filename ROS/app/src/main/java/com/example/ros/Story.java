package com.example.ros;

import android.os.Bundle;
import android.view.View;

public class Story extends Page {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
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
        final View ST;

        ST = (View) findViewById(R.id.story_touch);

        ST.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Story.super.SwitchPage(Story2.class);
                finish();
            }
        });
    }
}
