package com.celilreha.yazilim_dilleri_ogren.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.celilreha.yazilim_dilleri_ogren.Model.Konu;
import com.celilreha.yazilim_dilleri_ogren.R;

public class DetayActivity extends AppCompatActivity {

    Konu konu;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        konu=(Konu)getIntent().getSerializableExtra("konu");
        this.setTitle(konu.getBaslik());//sayfanın başlığı değişti.
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);//toolbara geri butonu eklendi.

        webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/"+konu.getDosyaYolu());
        webView.getSettings().setJavaScriptEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
