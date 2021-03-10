package com.celilreha.yazilim_dilleri_ogren.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.celilreha.yazilim_dilleri_ogren.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.getSupportActionBar().hide();
        new Beklet().start();
    }
    private class Beklet extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish(); //SplashActivity sayfasını kalıcı olarak kapatır.
        }
    }
}
