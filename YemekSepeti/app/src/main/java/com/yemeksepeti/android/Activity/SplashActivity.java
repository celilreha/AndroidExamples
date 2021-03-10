package com.yemeksepeti.android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yemeksepeti.android.R;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {
    Button buttonSignIn,buttonSignUp;
    ImageView ivSplash_Background;
    int[] bgImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.getSupportActionBar().hide();


        bgImages = new int[3];
        bgImages[0]=R.drawable.background;
        bgImages[1]=R.drawable.background1;
        bgImages[2]=R.drawable.background2;

        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        ivSplash_Background = findViewById(R.id.ivSplash_Background);
        Random random = new Random();
        ivSplash_Background.setImageResource(bgImages[random.nextInt(3)]);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),LoginRegisterActivity.class);
                intent.putExtra("action","sign_in");
                startActivity(intent);
                finish();
            }
        });
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),LoginRegisterActivity.class);
                intent.putExtra("action","sign_up");
                startActivity(intent);
                finish();
            }
        });
    }
}
