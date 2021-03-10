package com.celilreha.yazilim_dilleri_ogren.Activity;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.celilreha.yazilim_dilleri_ogren.Model.Konu;
import com.celilreha.yazilim_dilleri_ogren.Model.Yazilim_Dili;
import com.celilreha.yazilim_dilleri_ogren.R;

import java.util.ArrayList;

public class KonularActivity extends AppCompatActivity {


    ListView listView;
    Yazilim_Dili yazilimDili;
    ArrayList<Konu> konular = new ArrayList<>();
    ArrayAdapter<Konu> adapterKonular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konular);


        yazilimDili = (Yazilim_Dili)getIntent().getSerializableExtra("dil");
        this.setTitle(yazilimDili.getBaslik()); //sayfanın başlığını tıklanan satırdan aldık
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //toolbara geri git butonunu ekler


        if("Android Programlama".equals(yazilimDili.getBaslik())){
            //int id, int yazilimDilId, String baslik, String dosyaYolu
            konular.add(new Konu(1,yazilimDili.getId(),"Layout Kullanımı","android/layout.html"));
            konular.add(new Konu(2,yazilimDili.getId(),"Resources Kavramları","android/resources.html"));
            konular.add(new Konu(3,yazilimDili.getId(),"Activity Lifecycle","android/lifecycle.html"));
            konular.add(new Konu(4,yazilimDili.getId(),"LogCat Yapısı","android/logcat.html"));
            konular.add(new Konu(5,yazilimDili.getId(),"Toast Kullanımı","android/toast.html"));
            konular.add(new Konu(6,yazilimDili.getId(),"AlertDialog Kullanımı","android/alertdialog.html"));
            konular.add(new Konu(7,yazilimDili.getId(),"Button Olaylari","android/button.html"));
            konular.add(new Konu(8,yazilimDili.getId(),"EditText Olaylari","android/edittext.html"));
            konular.add(new Konu(9,yazilimDili.getId(),"İntent Kullanımları","android/intent.html"));
            konular.add(new Konu(10,yazilimDili.getId(),"ArrayAdapter Kullanımları","android/arrayadapter.html"));
            konular.add(new Konu(11,yazilimDili.getId(),"BaseAdapter Kullanımları","android/baseadapter.html"));
            konular.add(new Konu(12,yazilimDili.getId(),"SharedPreferences Kullanımı","android/sharedpreferences.html"));
        }



        adapterKonular = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                konular
        );

        listView = findViewById(R.id.listViewKonular);
        listView.setAdapter(adapterKonular);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DetayActivity.class);
                intent.putExtra("konu",konular.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
