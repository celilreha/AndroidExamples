package com.celilreha.activity_life_cycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("durum","onCreate metodu çalıştı");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("durum","onStart metodu çalıştı");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("durum","onResume metodu çalıştı");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("durum","onPause metodu çalıştı");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("durum","onStop metodu çalıştı");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("durum","onDestroy metodu çalıştı");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("durum","onRestart metodu çalıştı");
    }




}
