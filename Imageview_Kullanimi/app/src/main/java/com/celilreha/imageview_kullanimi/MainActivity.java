package com.celilreha.imageview_kullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGS,btnFB,btnBJK,btnTS;
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGS = findViewById(R.id.btnGS);
        btnFB = findViewById(R.id.btnFB);
        btnBJK = findViewById(R.id.btnBJK);
        btnTS = findViewById(R.id.btnTS);
        ivLogo = findViewById(R.id.ivLogo);

        btnGS.setOnClickListener(this);
        btnFB.setOnClickListener(this);
        btnBJK.setOnClickListener(this);
        btnTS.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnGS)
        ivLogo.setImageResource(R.drawable.gs);
        else if(v.getId()==R.id.btnFB)
            ivLogo.setImageResource(R.drawable.fb);
        else if(v.getId()==R.id.btnBJK)
            ivLogo.setImageResource(R.drawable.bjk);
        else if(v.getId()==R.id.btnTS)
            ivLogo.setImageResource(R.drawable.ts);


    }
}
