package com.celilreha.soru_bankasi.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.celilreha.soru_bankasi.Adapter.Adapter_Konu;
import com.celilreha.soru_bankasi.Helper.DatabaseHelper;
import com.celilreha.soru_bankasi.Model.Ders;
import com.celilreha.soru_bankasi.Model.Konu;
import com.celilreha.soru_bankasi.R;

import java.io.IOException;
import java.util.ArrayList;

public class KonuActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Konu> konular=new ArrayList<>();
    Ders ders;
    Adapter_Konu adapter_konu;
    SQLiteDatabase db;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konu);
        listView=findViewById(R.id.listViewKonular);
        ders=(Ders)getIntent().getSerializableExtra("Ders");
        this.setTitle(ders.getDersAdi());
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            db=databaseHelper.getReadableDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Cursor c = db.rawQuery("select * from Konu where ders_id="+ders.getId(),null);
        while (c.moveToNext()){
            konular.add(new Konu(
                    c.getInt(c.getColumnIndex("id")),
                    c.getInt(c.getColumnIndex("ders_id")),
                    c.getString(c.getColumnIndex("ad")),
                    c.getString(c.getColumnIndex("aciklama")),ders.getSoruSayisi()));
        }

        //int id, int dersId, String konuAdi, String konuAciklama, int soruSayisi
        /*for (int i=1;i<10;i++) {
            konular.add(new Konu(i, 1, "Konu Adı "+i, "Açıklama", i*25));
        }*/
        adapter_konu=new Adapter_Konu(getApplicationContext(),konular);
        listView.setAdapter(adapter_konu);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),SoruCozumActivity.class);
                intent.putExtra("konu",konular.get(position));
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}