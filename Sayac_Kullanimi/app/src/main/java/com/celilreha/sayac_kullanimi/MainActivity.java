package com.celilreha.sayac_kullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSayac;
    TextView tvSayac;
    int sayac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sayac=0;
        tvSayac = findViewById(R.id.tvsayac);
        btnSayac = findViewById(R.id.btnSayac);

        btnSayac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac++;
                tvSayac.setText(""+sayac);
            }
        });
    }
}
