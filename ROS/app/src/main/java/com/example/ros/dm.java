package com.example.ros;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;


public class dm extends Event {
    private TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dm);
        final WebView webView = (WebView) findViewById(R.id.webview);
        txt1.setText("Loading....");

        new Thread(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("http://www.edamall.com.tw/DM_MALL/DM_Mobile/DM_1/index.html");
            }
        }).start();
    }
}
