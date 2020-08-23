package com.example.ros;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Brand extends Page {

    private int total;
    private int allnum;
    private int thisnum;
    private int a = 0;
    private int b = 1;
    private int c = 2;
    private int d = 3;
    private ArrayList<String> storeID = new ArrayList<String>();
    private ArrayList<String> brandID = new ArrayList<String>();
    private ArrayList<String> Name = new ArrayList<String>();
    private ArrayList<String> zone = new ArrayList<String>();
    private ArrayList<String> floor = new ArrayList<String>();
    private ArrayList<String> content = new ArrayList<String>();
    private ArrayList<String> openTime = new ArrayList<String>();
    private ArrayList<String> logo = new ArrayList<String>();
    private ArrayList<String> big = new ArrayList<String>();

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txtAll;
    private TextView txtThis;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private GifImageView image1;
    private GifImageView image2;
    private GifImageView image3;
    private GifImageView image4;
    private Button btL;
    private Button btR;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.brand);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Bundle bundle = this.getIntent().getExtras();
        final String BrandType = bundle.getString("BrandType");
        Log.e("BrandType", BrandType);

        image1 = (GifImageView) findViewById(R.id.image1);
        image2 = (GifImageView) findViewById(R.id.image2);
        image3 = (GifImageView) findViewById(R.id.image3);
        image4 = (GifImageView) findViewById(R.id.image4);
        title = (TextView)findViewById(R.id.main);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txtAll = (TextView)findViewById(R.id.txtAll);
        txtThis = (TextView)findViewById(R.id.txtThis);
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        btL = (Button)findViewById(R.id.btL);
        btR = (Button)findViewById(R.id.btR);
        final Button btBack = (Button)findViewById(R.id.btBack);
        final Button btHome = (Button)findViewById(R.id.btHome);

        btL.setClickable(false);
        btL.setAlpha((float) 0.3);

        thisnum = 1;
        txtThis.setText(numToStr(thisnum));


        //set View shadow
        ViewCompat.setElevation(imageView1, 16);
        ViewCompat.setElevation(imageView2, 16);
        ViewCompat.setElevation(imageView3, 16);
        ViewCompat.setElevation(imageView4, 16);

        if(BrandType.equals("1")){
            title.setText(R.string.t1);
        }else if (BrandType.equals("2")){
            title.setText(R.string.t2);
        }else if (BrandType.equals("3")){
            title.setText(R.string.t3);
        }else if (BrandType.equals("4")){
            title.setText(R.string.t4);
        }else if (BrandType.equals("5")){
            title.setText(R.string.t5);
        }else if (BrandType.equals("6")){
            title.setText(R.string.t6);
        }else if (BrandType.equals("7")){
            title.setText(R.string.t7);
        }else if (BrandType.equals("8")){
            title.setText(R.string.t8);
        }

        txt1.setText("Loading...."); txt2.setText("Loading...."); txt3.setText("Loading...."); txt4.setText("Loading....");

        try {
            // 如果載入的是gif動圖，第一步需要先將gif動圖資源轉化為GifDrawable
            // 將gif圖資源轉化為GifDrawable
            GifDrawable gifDrawable1 = new GifDrawable(getResources(), R.drawable.loading);
            GifDrawable gifDrawable2 = new GifDrawable(getResources(), R.drawable.loading);
            GifDrawable gifDrawable3 = new GifDrawable(getResources(), R.drawable.loading);
            GifDrawable gifDrawable4 = new GifDrawable(getResources(), R.drawable.loading);
            // gif1載入一個動態圖gif
            image1.setImageDrawable(gifDrawable1);
            image2.setImageDrawable(gifDrawable2);
            image3.setImageDrawable(gifDrawable3);
            image4.setImageDrawable(gifDrawable4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        btL.setOnClickListener(new OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View v){
                setAnimation();

                if (thisnum==1){
                    txtThis.setText(numToStr(thisnum));
                }else {
                    thisnum--;
                    txtThis.setText(numToStr(thisnum));
                }

                a-=4; b-=4; c-=4; d-=4;

                if(a==-4){
                    a+=4; b+=4; c+=4; d+=4;
                }else if(a==0){
                    btL.setClickable(false);
                    btL.setAlpha((float) 0.3);
                }else{
                    btL.setClickable(true);
                    btL.setAlpha((float) 1);
                }

                if(d>total-1){
                    int num = d+1 - total;
                    if(num == 1){
                        txt1.setText(Name.get(a));
                        txt2.setText(Name.get(b));
                        txt3.setText(Name.get(c));
                        txt1.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.VISIBLE);
                        txt3.setVisibility(View.VISIBLE);
                        setLOGO(imageView1, logo.get(a));
                        setLOGO(imageView2, logo.get(b));
                        setLOGO(imageView3, logo.get(c));

                        imageView4.setBackgroundResource(R.mipmap.empty);
                        imageView4.setVisibility(View.GONE);
                        txt4.setVisibility(View.GONE);
                        btR.setClickable(false);
                        btR.setAlpha((float) 0.3);
                        setVis(image4);
                    }else if(num == 2){
                        txt1.setText(Name.get(a));
                        txt2.setText(Name.get(b));
                        txt1.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.VISIBLE);
                        setLOGO(imageView1, logo.get(a));
                        setLOGO(imageView2, logo.get(b));

                        imageView3.setBackgroundResource(R.mipmap.empty);
                        imageView4.setBackgroundResource(R.mipmap.empty);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        txt3.setVisibility(View.GONE);
                        txt4.setVisibility(View.GONE);
                        btR.setClickable(false);
                        btR.setAlpha((float) 0.3);
                        setVis(image3);
                        setVis(image4);
                    }else if(num == 3){
                        txt1.setText(Name.get(a));
                        txt1.setVisibility(View.VISIBLE);
                        setLOGO(imageView1, logo.get(a));

                        imageView2.setBackgroundResource(R.mipmap.empty);
                        imageView3.setBackgroundResource(R.mipmap.empty);
                        imageView4.setBackgroundResource(R.mipmap.empty);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        txt2.setVisibility(View.GONE);
                        txt3.setVisibility(View.GONE);
                        txt4.setVisibility(View.GONE);
                        btR.setClickable(false);
                        btR.setAlpha((float) 0.3);
                        setVis(image2);
                        setVis(image3);
                        setVis(image4);
                    }
                }else if(d == total-1){
                    txt1.setText(Name.get(a));
                    txt2.setText(Name.get(b));
                    txt3.setText(Name.get(c));
                    txt4.setText(Name.get(d));
                    txt1.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                    txt3.setVisibility(View.VISIBLE);
                    txt4.setVisibility(View.VISIBLE);

                    setLOGO(imageView1, logo.get(a));
                    setLOGO(imageView2, logo.get(b));
                    setLOGO(imageView3, logo.get(c));
                    setLOGO(imageView4, logo.get(d));
                    imageView1.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView2.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView3.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView4.setBackgroundResource(R.drawable.bd_circle_shape);
                    btR.setClickable(false);
                    btR.setAlpha((float) 0.3);

                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.VISIBLE);
                    image3.setVisibility(View.VISIBLE);
                    image4.setVisibility(View.VISIBLE);
                }else{
                    txt1.setText(Name.get(a));
                    txt2.setText(Name.get(b));
                    txt3.setText(Name.get(c));
                    txt4.setText(Name.get(d));
                    txt1.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                    txt3.setVisibility(View.VISIBLE);
                    txt4.setVisibility(View.VISIBLE);

                    setLOGO(imageView1, logo.get(a));
                    setLOGO(imageView2, logo.get(b));
                    setLOGO(imageView3, logo.get(c));
                    setLOGO(imageView4, logo.get(d));
                    imageView1.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView2.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView3.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView4.setBackgroundResource(R.drawable.bd_circle_shape);
                    btR.setClickable(true);
                    btR.setAlpha((float) 1);

                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.VISIBLE);
                    image3.setVisibility(View.VISIBLE);
                    image4.setVisibility(View.VISIBLE);
                }
            }
        });

        btR.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                setAnimation();

                if (thisnum==allnum){
                    txtThis.setText(numToStr(thisnum));
                }else {
                    thisnum++;
                    txtThis.setText(numToStr(thisnum));
                }

                a+=4; b+=4; c+=4; d+=4;

                if(a==0){
                    btL.setClickable(false);
                    btL.setAlpha((float) 0.3);
                }else{
                    btL.setClickable(true);
                    btL.setAlpha((float) 1);
                }

                if (Name.size()==4){
                    a-=4; b-=4; c-=4; d-=4;
                }else if(d>total-1){
                    int num = d+1 - total;
                    if(num == 1){
                        txt1.setText(Name.get(a));
                        txt2.setText(Name.get(b));
                        txt3.setText(Name.get(c));
                        txt1.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.VISIBLE);
                        txt3.setVisibility(View.VISIBLE);
                        setLOGO(imageView1, logo.get(a));
                        setLOGO(imageView2, logo.get(b));
                        setLOGO(imageView3, logo.get(c));

                        imageView4.setBackgroundResource(R.mipmap.empty);
                        imageView4.setVisibility(View.GONE);
                        txt4.setVisibility(View.GONE);
                        btR.setClickable(false);
                        btR.setAlpha((float) 0.3);
                        setVis(image4);
                    }else if(num == 2){
                        txt1.setText(Name.get(a));
                        txt2.setText(Name.get(b));
                        txt1.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.VISIBLE);
                        setLOGO(imageView1, logo.get(a));
                        setLOGO(imageView2, logo.get(b));

                        imageView3.setBackgroundResource(R.mipmap.empty);
                        imageView4.setBackgroundResource(R.mipmap.empty);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        txt3.setVisibility(View.GONE);
                        txt4.setVisibility(View.GONE);
                        btR.setClickable(false);
                        btR.setAlpha((float) 0.3);
                        setVis(image3);
                        setVis(image4);
                    }else if(num == 3){
                        txt1.setText(Name.get(a));
                        txt1.setVisibility(View.VISIBLE);
                        setLOGO(imageView1, logo.get(a));

                        imageView2.setBackgroundResource(R.mipmap.empty);
                        imageView3.setBackgroundResource(R.mipmap.empty);
                        imageView4.setBackgroundResource(R.mipmap.empty);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        txt2.setVisibility(View.GONE);
                        txt3.setVisibility(View.GONE);
                        txt4.setVisibility(View.GONE);
                        btR.setClickable(false);
                        btR.setAlpha((float) 0.3);
                        setVis(image2);
                        setVis(image3);
                        setVis(image4);
                    }
                }else if(d == total-1){
                    txt1.setText(Name.get(a));
                    txt2.setText(Name.get(b));
                    txt3.setText(Name.get(c));
                    txt4.setText(Name.get(d));
                    txt1.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                    txt3.setVisibility(View.VISIBLE);
                    txt4.setVisibility(View.VISIBLE);

                    setLOGO(imageView1, logo.get(a));
                    setLOGO(imageView2, logo.get(b));
                    setLOGO(imageView3, logo.get(c));
                    setLOGO(imageView4, logo.get(d));
                    imageView1.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView2.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView3.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView4.setBackgroundResource(R.drawable.bd_circle_shape);
                    btR.setClickable(false);
                    btR.setAlpha((float) 0.3);

                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.VISIBLE);
                    image3.setVisibility(View.VISIBLE);
                    image4.setVisibility(View.VISIBLE);
                }else{
                    txt1.setText(Name.get(a));
                    txt2.setText(Name.get(b));
                    txt3.setText(Name.get(c));
                    txt4.setText(Name.get(d));
                    txt1.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                    txt3.setVisibility(View.VISIBLE);
                    txt4.setVisibility(View.VISIBLE);

                    setLOGO(imageView1, logo.get(a));
                    setLOGO(imageView2, logo.get(b));
                    setLOGO(imageView3, logo.get(c));
                    setLOGO(imageView4, logo.get(d));
                    imageView1.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView2.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView3.setBackgroundResource(R.drawable.bd_circle_shape);
                    imageView4.setBackgroundResource(R.drawable.bd_circle_shape);
                    btR.setClickable(true);
                    btR.setAlpha((float) 1);

                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.VISIBLE);
                    image3.setVisibility(View.VISIBLE);
                    image4.setVisibility(View.VISIBLE);
                }
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

        imageView1.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

            }
        });

        imageView2.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

            }
        });

        imageView3.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

            }
        });

        imageView4.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn = null;
                try {
                    String mWeatherUrl = "http://cgutemi.nctu.me/BrandLists/"+BrandType;

                    URL url = new URL(mWeatherUrl);
                    conn = (HttpURLConnection) url.openConnection(); // open connect
                    conn.setRequestMethod("GET");										 // using GET method
                    int responseCode = conn.getResponseCode();       // responseCode will return what eror.
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));   //read your data
                    String inputLine = "";
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    Log.d("Response", response.toString());


                        JSONObject jsonObject1 = new JSONObject(response.toString());
                        JSONArray jsonArray = jsonObject1.getJSONArray(BrandType);
                        total = jsonArray.length();
                        if (total%4==0){
                            allnum = total/4;
                        }else {
                            allnum = (total/4)+1;
                        }

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            //取出name
                            String StoreID = jsonObject.getString("StoreID");
                            String BrandID = jsonObject.getString("BrandID");
                            String BrandName = jsonObject.getString("BrandName");
                            String ZoneID = jsonObject.getString("ZoneID");
                            String Floor = jsonObject.getString("Floor");
                            //String Link = jsonObject.getString("Link");
                            String Content = jsonObject.getString("Content");
                            String OpenTime = jsonObject.getString("OpenTime");
                            String BrandPicB = jsonObject.getString("BrandPicB");
                            String BrandPicBIG = jsonObject.getString("BrandPicBIG");

                            Log.e("StoreID", StoreID);
                            Log.e("BrandID", BrandID);
                            Log.e("BrandName", BrandName);
                            Log.e("ZoneID", ZoneID);
                            Log.e("Floor", Floor);
                            //Log.e("Link", Link);
                            Log.e("Content", Content);
                            Log.e("OpenTime", OpenTime);
                            Log.e("BrandPicB", BrandPicB);
                            Log.e("BrandPicBIG", BrandPicBIG);

                            storeID.add(StoreID);
                            brandID.add(BrandID);
                            Name.add(BrandName);
                            zone.add(ZoneID);
                            floor.add(Floor);
                            content.add(Content);
                            openTime.add(OpenTime);
                            logo.add(BrandPicB);
                            big.add(BrandPicBIG);


                            if (i==3){
                            Log.e("Start", "Start");
                            setText(txt1, Name.get(0));
                            setText(txt2, Name.get(1));
                            setText(txt3, Name.get(2));
                            setText(txt4, Name.get(3));
                            setLOGO(imageView1, logo.get(0));
                            setLOGO(imageView2, logo.get(1));
                            setLOGO(imageView3, logo.get(2));
                            setLOGO(imageView4, logo.get(3));
                            Log.e("Finish", "Finish");
                            }
                        }

                        setText(txtAll, numToStr(allnum));

                    if (jsonArray.length()==4){
                        btR.setClickable(false);
                        btR.setAlpha((float) 0.3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (conn != null) conn.disconnect();               //make sure you disconnnect
                }
            }
        }).start();

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

    private void setLOGO(final ImageView imageView, final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Glide.with(Brand.this)
                        .asBitmap()
                        .load(value)
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                imageView.setImageBitmap(resource);
                            }
                        });
                imageView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void setText(final TextView text,final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }

    private void setVis(final GifImageView image){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                image.setVisibility(View.GONE);
            }
        });
    }

    private void  setAnimation(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txt1.setVisibility(View.GONE);
                txt2.setVisibility(View.GONE);
                txt3.setVisibility(View.GONE);
                txt4.setVisibility(View.GONE);
                imageView1.setVisibility(View.GONE);
                imageView2.setVisibility(View.GONE);
                imageView3.setVisibility(View.GONE);
                imageView4.setVisibility(View.GONE);
            }
        });

    }

    private String numToStr(final int i){
        String s = new String(""+i);

        return s;
    }
}