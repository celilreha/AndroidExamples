package com.celilreha.recylerview_multi2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.celilreha.recylerview_multi2.Adapter.RecylerViewAdapter;
import com.celilreha.recylerview_multi2.Model.Is_Ilan;
import com.celilreha.recylerview_multi2.Model.Meslek;
import com.celilreha.recylerview_multi2.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecylerViewAdapter recylerViewAdapter;
    List<Object> objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        objects = new ArrayList<>();
        objects.add(new Meslek("Bilgisayar Mühendisi",R.drawable.resim1));
        objects.add(new Meslek("Mimar",R.drawable.resim2));
        objects.add(new Is_Ilan("Baslik",5000,"Firma Adresi"));
        objects.add(new Meslek("Doktor",R.drawable.resim3));
        objects.add(new Meslek("Hemşire",R.drawable.resim4));
        objects.add(new Meslek("Avukat",R.drawable.resim5));
        objects.add(new Meslek("Öğretmen",R.drawable.resim6));

        recylerViewAdapter = new RecylerViewAdapter(objects,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(recylerViewAdapter);
    }
}
