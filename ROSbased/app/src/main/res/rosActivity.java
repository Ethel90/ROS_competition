package com.example.ros;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class rosActivity extends Page {
    private Context one = rosActivity.this;
    private Class two = MainActivity.class;

    private Button btSpecial;
    private Button btDM;
    private Button btBack;
    private Button btHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rosactivity);
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

    private  void buildViews(){
        btSpecial = (Button)findViewById(R.id.btSpecial);
        btDM = (Button)findViewById(R.id.btDM);
        btBack = (Button)findViewById(R.id.btBack);
        btHome = (Button)findViewById(R.id.btHome);

        btSpecial.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                rosActivity.super.SwitchPage(two);
            }
        });

        btDM.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                rosActivity.super.SwitchPage(two);
            }
        });

        btBack.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                rosActivity.super.LastPage(one, two);
            }
        });

        btHome.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                rosActivity.super.HomePage(one);
            }
        });
    }
}
