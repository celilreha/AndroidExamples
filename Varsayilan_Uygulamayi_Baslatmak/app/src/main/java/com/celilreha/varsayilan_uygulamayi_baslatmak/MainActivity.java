package com.celilreha.varsayilan_uygulamayi_baslatmak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnWeb,btnSms,btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSms = findViewById(R.id.btnSms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                Uri uri=Uri.parse("sms:+905367259859");
                intent.setData(uri);
                startActivity(intent);

            }
        });

        btnWeb = findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                Uri uri= Uri.parse("http://serifgungor.com");
                intent.setData(uri);
                startActivity(intent);
            }
        });
        btnMap=findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri=Uri.parse("geo:0,0?q=41.0085814,28.9802257");
                intent.setData(uri);
                startActivity(intent);
            }
        });

    }
}
