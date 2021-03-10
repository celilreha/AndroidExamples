package com.celilreha.programatik_nesne_ekleme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    LinearLayout linearLayout;
    public void nesneEkle(String nesneAdi,String yazi){
        if("textview".equals(nesneAdi)){
            TextView textView= new TextView(getApplicationContext());
            textView.setText(yazi);
            linearLayout.addView(textView);

        }else if("button".equals(nesneAdi)){
            Button button = new Button(getApplicationContext());
            button.setText(yazi);
            linearLayout.addView(button);

        }else if("imageview".equals(nesneAdi)){
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(R.drawable.ic_launcher_background);
            linearLayout.addView(imageView);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linear);
        nesneEkle("textview","Yazı 1");
        nesneEkle("textview","Yazı 2");
        nesneEkle("textview","Yazı 3");
        nesneEkle("button","Button 1");
        nesneEkle("button","Button 2");
        nesneEkle("button","Button 3");
        nesneEkle("imageview","");
        nesneEkle("imageview","");
        nesneEkle("imageview","");
    }
}
