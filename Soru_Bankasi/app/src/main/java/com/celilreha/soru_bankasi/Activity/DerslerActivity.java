package com.celilreha.soru_bankasi.Activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.celilreha.soru_bankasi.Adapter.Adapter_Ders;
import com.celilreha.soru_bankasi.Helper.DatabaseHelper;
import com.celilreha.soru_bankasi.Model.Ders;
import com.celilreha.soru_bankasi.R;

import java.io.IOException;
import java.util.ArrayList;

public class DerslerActivity extends AppCompatActivity {

    ListView listView;
    Adapter_Ders adapter_ders;
    ArrayList<Ders> dersler = new ArrayList<>();
    SQLiteDatabase db;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dersler);
        listView=findViewById(R.id.listViewDersler);
        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            db= databaseHelper.getReadableDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Cursor c = db.rawQuery("select * from Ders",null);
        //int id, String dersAdi, String dersAciklama, String renk, int konuSayisi, int soruSayisi
        while (c.moveToNext()){
            dersler.add(new Ders(
                    c.getInt(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("ad")),
                    c.getString(c.getColumnIndex("aciklama")),
                    c.getString(c.getColumnIndex("renk")),
                    0,
                    0
                    ));
        }
        adapter_ders= new Adapter_Ders(getApplicationContext(),dersler);
        listView.setAdapter(adapter_ders);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),KonuActivity.class);
                intent.putExtra("Ders",dersler.get(position));
                startActivity(intent);
            }
        });
    }

}
