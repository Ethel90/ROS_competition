package com.example.ros;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Event extends Page {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
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

        btSpecial = (Button)findViewById(R.id.bt1);
        btDM = (Button)findViewById(R.id.bt2);
        btBack = (Button)findViewById(R.id.btBack);
        btHome = (Button)findViewById(R.id.btHome);



        btSpecial.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(Event.this, information.class);
                startActivity(intent);
            }
        });

        btDM.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                    Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                    myWebLink.setData(Uri.parse("http://www.edamall.com.tw/DM_MALL/DM_Mobile/DM_1/index.html"));
                    startActivity(myWebLink);

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
