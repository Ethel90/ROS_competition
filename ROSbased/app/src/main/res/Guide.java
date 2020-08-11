package com.example.ros;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Guide extends Page {
    private Context one = Guide.this;
    private Class two = MainActivity.class;

    private Button btA;
    private Button btB;
    private Button btC;
    private Button btD;
    private Button btE;
    private Button btF;
    private Button btG;
    private Button btH;
    private Button btBack;
    private Button btHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
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

    private  void buildViews() {
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
                Guide.super.SwitchPage(two);
            }
        });

        btB.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Guide.super.SwitchPage(two);
            }
        });

        btC.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Guide.super.SwitchPage(two);
            }
        });

        btD.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Guide.super.SwitchPage(two);
            }
        });

        btE.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Guide.super.SwitchPage(two);
            }
        });

        btF.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Guide.super.SwitchPage(two);
            }
        });

        btG.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Guide.super.SwitchPage(two);
            }
        });

        btH.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Guide.super.SwitchPage(two);
            }
        });

        btBack.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Guide.super.LastPage(one, two);
            }
        });

        btHome.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Guide.super.HomePage(one);
            }
        });
    }
}
