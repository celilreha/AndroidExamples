package com.yemeksepeti.android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.preference.PreferenceManager;

import com.yemeksepeti.android.R;

public class ControlActivity extends AppCompatActivity {
    SharedPreferences sp;
    int girisYapildiMi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        this.getSupportActionBar().hide();

        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        girisYapildiMi=sp.getInt("remember",0   );
        new Beklet().start();

    }
    private class Beklet extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*
            0 = id şifre bilinmiyor
            1 = id şifre biliniyor
             */
            if (girisYapildiMi==0){
                startActivity(new Intent(getApplicationContext(),SplashActivity.class));
            }else if(girisYapildiMi==1){
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        }
    }
}
