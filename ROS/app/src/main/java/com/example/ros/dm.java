package com.example.ros;

import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class dm extends Event {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dm);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("http://www.edamall.com.tw/DM_MALL/DM_Mobile/DM_1/index.html");

    }
}
