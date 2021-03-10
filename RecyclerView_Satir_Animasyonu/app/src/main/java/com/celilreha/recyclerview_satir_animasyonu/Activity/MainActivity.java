package com.celilreha.recyclerview_satir_animasyonu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.celilreha.recyclerview_satir_animasyonu.Adapter.AdapterKisi;
import com.celilreha.recyclerview_satir_animasyonu.Model.Kisi;
import com.celilreha.recyclerview_satir_animasyonu.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterKisi adapterKisi;
    ArrayList<Kisi> kisiler = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        for (int i=0;i<10;i++){
            kisiler.add(new Kisi("Ad Soyad"+i,""));
        }
        adapterKisi = new AdapterKisi(kisiler);
        recyclerView.setAdapter(adapterKisi);
        int resId=R.anim.layout_animation_fall_down;
        LayoutAnimationController animation= AnimationUtils.loadLayoutAnimation(getApplicationContext(),resId);
        recyclerView.setLayoutAnimation(animation);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
