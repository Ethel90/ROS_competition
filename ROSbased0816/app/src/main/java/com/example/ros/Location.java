package com.example.ros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Location extends Page {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
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

        final Button btA;
        final Button btB;
        final Button btC;
        final Button btD;
        final Button btE;
        final Button btF;
        final Button btG;
        final Button btH;
        final Button btBack;
        final Button btHome;

        btA = (Button)findViewById(R.id.btA);
        btB = (Button)findViewById(R.id.btB);
        btC = (Button)findViewById(R.id.btC);
        btD = (Button)findViewById(R.id.btD);
        btE = (Button)findViewById(R.id.btE);
        btF = (Button)findViewById(R.id.btF);
        btG = (Button)findViewById(R.id.btG);
        btH = (Button)findViewById(R.id.btH);
        btBack = (Button)findViewById(R.id.btBack);
        btHome = (Button)findViewById(R.id.btHome);

        btA.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(Location.this, Brand.class);

                Bundle bundle = new Bundle();
                bundle.putString("Brand", "a");
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        btB.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Location.super.SwitchPage(nextPage);
            }
        });

        btC.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Location.super.SwitchPage(nextPage);
            }
        });

        btD.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Location.super.SwitchPage(nextPage);
            }
        });

        btE.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Location.super.SwitchPage(nextPage);
            }
        });

        btF.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Location.super.SwitchPage(nextPage);
            }
        });

        btG.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Location.super.SwitchPage(nextPage);
            }
        });

        btH.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Location.super.SwitchPage(nextPage);
            }
        });

        btBack.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Location.super.LastPage();
            }
        });

        btHome.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Location.super.HomePage();
            }
        });
    }
}
