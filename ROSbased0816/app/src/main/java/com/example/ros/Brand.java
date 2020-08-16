package com.example.ros;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Brand extends Page {
    private int i;
    private int total;
    private int a = 0;
    private int b = 1;
    private int c = 2;
    private int d = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brand);
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

        final Button btA;
        final Button btB;
        final Button btC;
        final Button btD;
        final TextView txtA;
        final TextView txtB;
        final TextView txtC;
        final TextView txtD;
        final Button btL;
        final Button btR;
        final Button btBack;
        final Button btHome;

        btA = (Button)findViewById(R.id.btA);
        btB = (Button)findViewById(R.id.btB);
        btC = (Button)findViewById(R.id.btC);
        btD = (Button)findViewById(R.id.btD);
        txtA = (TextView)findViewById(R.id.txtA);
        txtB = (TextView)findViewById(R.id.txtB);
        txtC = (TextView)findViewById(R.id.txtC);
        txtD = (TextView)findViewById(R.id.txtD);
        btL = (Button)findViewById(R.id.btL);
        btR = (Button)findViewById(R.id.btR);
        btBack = (Button)findViewById(R.id.btBack);
        btHome = (Button)findViewById(R.id.btHome);

        final String[][] name = {{"a.testoni","AIGNER","AIGLE","ARMANI OUTLET","Arnold Palmer","BAZAAR","Bluebell","Brooks Brothers","borsalini","COACH FACTORY"}};

        Bundle bundle = this.getIntent().getExtras();
        String string = bundle.getString("Brand");

        if(string.equals("a")){
            i = 0;
            total = 10;
            txtA.setText(name[i][a]);
            txtB.setText(name[i][b]);
            txtC.setText(name[i][c]);
            txtD.setText(name[i][d]);
        }

        btA.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

            }
        });

        btB.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

            }
        });

        btC.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

            }
        });

        btD.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

            }
        });

        btL.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                a-=4; b-=4; c-=4; d-=4;

                if(a==0){
                    btL.setVisibility(v.GONE);
                }else if(a!=0){
                    btL.setVisibility(v.VISIBLE);}

                if(d>total){
                    int num = d+1 - total;
                    if(num == 1){
                        txtA.setText(name[i][a]);
                        txtB.setText(name[i][b]);
                        txtC.setText(name[i][c]);

                        btD.setBackgroundResource(R.mipmap.empty);
                        btD.setVisibility(v.GONE);
                        txtD.setVisibility(v.GONE);
                        btR.setVisibility(v.GONE);
                    }else if(num == 2){
                        txtA.setText(name[i][a]);
                        txtB.setText(name[i][b]);

                        btC.setBackgroundResource(R.mipmap.empty);
                        btD.setBackgroundResource(R.mipmap.empty);
                        btC.setVisibility(v.GONE);
                        btD.setVisibility(v.GONE);
                        txtC.setVisibility(v.GONE);
                        txtD.setVisibility(v.GONE);
                        btR.setVisibility(v.GONE);
                    }else if(num == 3){
                        txtA.setText(name[i][a]);

                        btB.setBackgroundResource(R.mipmap.empty);
                        btC.setBackgroundResource(R.mipmap.empty);
                        btD.setBackgroundResource(R.mipmap.empty);
                        btB.setVisibility(v.GONE);
                        btC.setVisibility(v.GONE);
                        btD.setVisibility(v.GONE);
                        txtB.setVisibility(v.GONE);
                        txtC.setVisibility(v.GONE);
                        txtD.setVisibility(v.GONE);
                        btR.setVisibility(v.GONE);
                    }
                }else if(d == total){
                    btR.setVisibility(v.GONE);
                }else{
                    txtA.setText(name[i][a]);
                    txtB.setText(name[i][b]);
                    txtC.setText(name[i][c]);
                    txtD.setText(name[i][d]);
                    txtA.setVisibility(v.VISIBLE);
                    txtB.setVisibility(v.VISIBLE);
                    txtC.setVisibility(v.VISIBLE);
                    txtD.setVisibility(v.VISIBLE);
                    btA.setVisibility(v.VISIBLE);
                    btB.setVisibility(v.VISIBLE);
                    btC.setVisibility(v.VISIBLE);
                    btD.setVisibility(v.VISIBLE);
                    btR.setVisibility(v.VISIBLE);}
            }
        });

        btR.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                a+=4; b+=4; c+=4; d+=4;

                if(a==0){
                    btL.setVisibility(v.GONE);
                }else{
                    btL.setVisibility(v.VISIBLE);}

                if(d>total){
                    int num = d+1 - total;
                    if(num == 1){
                        txtA.setText(name[i][a]);
                        txtB.setText(name[i][b]);
                        txtC.setText(name[i][c]);

                        btD.setBackgroundResource(R.mipmap.empty);
                        btD.setVisibility(v.GONE);
                        txtD.setVisibility(v.GONE);
                        btR.setVisibility(v.GONE);
                    }else if(num == 2){
                        txtA.setText(name[i][a]);
                        txtB.setText(name[i][b]);

                        btC.setBackgroundResource(R.mipmap.empty);
                        btD.setBackgroundResource(R.mipmap.empty);
                        btC.setVisibility(v.GONE);
                        btD.setVisibility(v.GONE);
                        txtC.setVisibility(v.GONE);
                        txtD.setVisibility(v.GONE);
                        btR.setVisibility(v.GONE);
                    }else if(num == 3){
                        txtA.setText(name[i][a]);

                        btB.setBackgroundResource(R.mipmap.empty);
                        btC.setBackgroundResource(R.mipmap.empty);
                        btD.setBackgroundResource(R.mipmap.empty);
                        btB.setVisibility(v.GONE);
                        btC.setVisibility(v.GONE);
                        btD.setVisibility(v.GONE);
                        txtB.setVisibility(v.GONE);
                        txtC.setVisibility(v.GONE);
                        txtD.setVisibility(v.GONE);
                        btR.setVisibility(v.GONE);
                    }
                }else if(d == total){
                    btR.setVisibility(v.GONE);
                }else{
                    txtA.setText(name[i][a]);
                    txtB.setText(name[i][b]);
                    txtC.setText(name[i][c]);
                    txtD.setText(name[i][d]);
                    txtA.setVisibility(v.VISIBLE);
                    txtB.setVisibility(v.VISIBLE);
                    txtC.setVisibility(v.VISIBLE);
                    txtD.setVisibility(v.VISIBLE);
                    btA.setVisibility(v.VISIBLE);
                    btB.setVisibility(v.VISIBLE);
                    btC.setVisibility(v.VISIBLE);
                    btD.setVisibility(v.VISIBLE);
                    btR.setVisibility(v.VISIBLE);}
            }
        });

        btBack.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Brand.super.LastPage();
            }
        });

        btHome.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Brand.super.HomePage();
            }
        });
    }
}