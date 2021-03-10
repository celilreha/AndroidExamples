package com.celilreha.webview_kullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        webView.loadUrl("http://www.github.com/celilreha");
        webView.getSettings().setJavaScriptEnabled(true);//js desteğini açar
        // hangi tarayıcı ile açılsın sorudu gelmez. içinde bulunan webview içerisinde açılır
        webView.setWebViewClient(new WebViewClient());
    }
}
