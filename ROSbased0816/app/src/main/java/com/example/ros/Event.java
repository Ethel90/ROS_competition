package com.example.ros;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Event extends Page {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
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

    private  void buildViews(){
        final Class nextPage = MainActivity.class;

        final Button btSpecial;
        final Button btDM;
        final Button btBack;
        final Button btHome;

        btSpecial = (Button)findViewById(R.id.btA);
        btDM = (Button)findViewById(R.id.btB);
        btBack = (Button)findViewById(R.id.btBack);
        btHome = (Button)findViewById(R.id.btHome);

        btSpecial.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Event.super.SwitchPage(nextPage);
            }
        });

        btDM.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Event.super.SwitchPage(nextPage);
            }
        });

        btBack.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Event.super.LastPage();
            }
        });

        btHome.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Event.super.HomePage();
            }
        });
    }
}
