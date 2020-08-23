package com.example.ros;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Failed extends Page {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.failed);
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
        final Button btHome;

        btHome = (Button) findViewById(R.id.btHome);

        btHome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Failed.super.HomePage();
            }
        });
    }
}