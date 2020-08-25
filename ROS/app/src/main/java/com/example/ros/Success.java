package com.example.ros;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Success extends Page {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //執行在主執行緒
                //啟動主頁面
                startActivity(new Intent(Success.this, Discount.class));
                finish();
            }
        },5000);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
//        buildViews();
        videoView = findViewById(R.id.videoView2);
        String VideoPath = "android.resource://" + getPackageName() + "/" + R.raw.video_success;
        Log.d("Tag", VideoPath);
        Uri uri= Uri.parse(VideoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.start();
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

//    private  void buildViews() {
//        final Button btHome;
//
//        btHome = (Button) findViewById(R.id.btHome);
//
//        btHome.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Success.super.HomePage();
//            }
 //       });
   // }
}