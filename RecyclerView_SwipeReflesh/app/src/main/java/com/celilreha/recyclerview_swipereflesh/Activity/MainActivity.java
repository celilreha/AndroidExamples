package com.celilreha.recyclerview_swipereflesh.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.celilreha.recyclerview_swipereflesh.Adapter.AdapterSayi;
import com.celilreha.recyclerview_swipereflesh.Model.Sayi;
import com.celilreha.recyclerview_swipereflesh.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    AdapterSayi adapterSayi;
    ArrayList<Sayi> sayilar=new ArrayList<>();

    int temp=20;

    public void sayiUret(int start,int finish){
        for(int i=start; i<=finish;i++){
            sayilar.add(new Sayi(i));
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = findViewById(R.id.swipe);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        sayiUret(1,20);
        adapterSayi = new AdapterSayi(sayilar);
        recyclerView.setAdapter(adapterSayi);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sayilar.clear();
                        sayiUret(temp,temp+=20);
                        adapterSayi.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);

            }
        });
        //swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,android.R.color.holo_green_light,android.R.color.holo_orange_light,android.R.color.holo_red_light);
    }
}
