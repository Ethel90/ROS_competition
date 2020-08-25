package com.example.ros;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;


import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import android.webkit.WebViewClient;
import android.content.pm.ActivityInfo;

public class dm extends Event {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dm);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        wv= (WebView)findViewById(R.id.webview); wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://www.edamall.com.tw/DM_MALL/DM_Mobile/DM_1/index.html");

//    private TextView txt1;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dm);
//        final WebView webView = (WebView) findViewById(R.id.webview);
//        txt1.setText("Loading....");

    }
}
