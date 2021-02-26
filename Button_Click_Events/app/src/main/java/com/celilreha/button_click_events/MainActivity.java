package com.celilreha.button_click_events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public void buton3eTikla(View view){
        Toast.makeText(getApplicationContext(),"Buton 3'e tıklandı",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        //Button b = (Button)v;
        //b.getText()
        Toast.makeText(
                getApplicationContext(),
                "Buton 2'ye tıklandı",
                Toast.LENGTH_SHORT
        ).show();



    }

    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(),
                        "Buton 1'e tıklandı",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        btn2.setOnClickListener(this);

    }


}
