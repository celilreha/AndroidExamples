package com.celilreha.recyclerview_horizontal_scroll.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.celilreha.recyclerview_horizontal_scroll.Adapter.Uygulama_Adapter;
import com.celilreha.recyclerview_horizontal_scroll.Model.Uygulama;
import com.celilreha.recyclerview_horizontal_scroll.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Uygulama_Adapter uygulama_adapter;
    ArrayList<Uygulama> uygulamaler = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        uygulamaler.add(new Uygulama(1,"Whatsapp","https://lh3.googleusercontent.com/bYtqbOcTYOlgc6gqZ2rwb8lptHuwlNE75zYJu6Bn076-hTmvd96HH-6v7S0YUAAJXoJN=s180-rw"));
        uygulamaler.add(new Uygulama(2,"Instagram","https://lh3.googleusercontent.com/2sREY-8UpjmaLDCTztldQf6u2RGUtuyf6VT5iyX3z53JS4TdvfQlX-rNChXKgpBYMw=s180-rw"));
        uygulamaler.add(new Uygulama(3,"Messenger","https://lh3.googleusercontent.com/rkBi-WHAI-dzkAIYjGBSMUToUoi6SWKoy9Fu7QybFb6KVOJweb51NNzokTtjod__MzA=s180-rw"));
        uygulamaler.add(new Uygulama(4,"Facebook","https://lh3.googleusercontent.com/ccWDU4A7fX1R24v-vvT480ySh26AYp97g1VrIB_FIdjRcuQB2JP2WdY7h_wVVAeSpg=s180-rw"));
        uygulamaler.add(new Uygulama(5,"Twitter","https://lh3.googleusercontent.com/q_HIXfU-Ywg5Jv08Ji7oqcBeYZe_MzoFd5P_9_x0A-McqMCxZ-vwgb_3vsd88e-Rbbc=s180-rw"));
        uygulamaler.add(new Uygulama(6,"Pinterest","https://lh3.googleusercontent.com/dVsv8Hc4TOUeLFAahxR8KANg22W9dj2jBsTW1VHv3CV-5NCZjP9D9i2j5IpfVx2NTB8=s180-rw"));
        uygulamaler.add(new Uygulama(7,"Netflix","https://lh3.googleusercontent.com/TBRwjS_qfJCSj1m7zZB93FnpJM5fSpMA_wUlFDLxWAb45T9RmwBvQd5cWR5viJJOhkI=s180-rw"));

        uygulama_adapter = new Uygulama_Adapter(uygulamaler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(uygulama_adapter);

        //Glide
    }
}
