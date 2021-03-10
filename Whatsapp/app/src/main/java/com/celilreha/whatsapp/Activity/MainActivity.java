package com.celilreha.whatsapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.celilreha.whatsapp.Adapter.SectionsPagerAdapter;
import com.celilreha.whatsapp.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabs;
    SectionsPagerAdapter sectionsPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.getSupportActionBar().hide();
        toolbar=findViewById(R.id.toolbar);
        viewPager=findViewById(R.id.viewPager);
        this.setSupportActionBar(toolbar);
        sectionsPagerAdapter = new SectionsPagerAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(viewPager);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.id_ayarlar){
            Toast.makeText(getApplicationContext(), "Ayarlar", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.id_whatsappWeb){
            Toast.makeText(getApplicationContext(), "Whatsapp Web", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.id_yeniGrup){
            Toast.makeText(getApplicationContext(), "Yeni Grup", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.id_yeniTopluMesaj){
            Toast.makeText(getApplicationContext(), "Yeni Toplu Mesaj", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.id_yeniTopluMesaj){
            Toast.makeText(getApplicationContext(), "Yıldızlı Mesajlar", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
