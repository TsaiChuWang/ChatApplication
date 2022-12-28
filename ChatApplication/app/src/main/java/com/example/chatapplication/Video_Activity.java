package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Video_Activity extends AppCompatActivity {
    WebView webview;
    WebSettings webSettings;
    String url="https://www.youtube.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        webview = findViewById(R.id.webview);
        webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);//開啟javascript功能
        webview.setWebViewClient(new WebViewClient());//新增瀏覽器客戶端
        webview.loadUrl(url);//讀取url網站
    }
}