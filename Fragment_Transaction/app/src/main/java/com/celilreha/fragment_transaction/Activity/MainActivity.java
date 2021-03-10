package com.celilreha.fragment_transaction.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.celilreha.fragment_transaction.Fragment.FragmentAnasayfa;
import com.celilreha.fragment_transaction.Fragment.FragmentHaberler;
import com.celilreha.fragment_transaction.Fragment.FragmentIletisim;
import com.celilreha.fragment_transaction.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3;
    FrameLayout frameLayout;

    public void icerigiDegistir(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout,fragment);
        ft.commit();
        /*
        fragmentTransaction sınıfı sayesinde framlelayout nesnesinin içeriğini Fragment sınıfının Layout görüntüsü ile doldurduk.
         */
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn1){
            icerigiDegistir(new FragmentAnasayfa());
        }else if(v.getId()==R.id.btn2){
            icerigiDegistir(new FragmentHaberler());
        }else if(v.getId()==R.id.btn3){
            icerigiDegistir(new FragmentIletisim());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.frameLayout);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }


}
