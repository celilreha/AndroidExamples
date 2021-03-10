package com.celilreha.yemek_tarifleri.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.celilreha.yemek_tarifleri.Adapter.Adapter_Tarif;
import com.celilreha.yemek_tarifleri.Helper.DatabaseHelper;
import com.celilreha.yemek_tarifleri.Model.Kategori;
import com.celilreha.yemek_tarifleri.Model.Tarif;
import com.celilreha.yemek_tarifleri.R;

import java.io.IOException;
import java.util.ArrayList;

public class TariflerActivity extends AppCompatActivity {

    ListView listView;
    Adapter_Tarif adapter_tarif;
    ArrayList<Tarif> tarifler;
    Kategori kategori;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifler);
        kategori = (Kategori)getIntent().getSerializableExtra("kategori");
        this.setTitle(kategori.getAd());
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tarifler = new ArrayList<>();
        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            db=databaseHelper.getReadableDatabase();
            Cursor c=db.rawQuery("SELECT * FROM Tarif WHERE kategori_id="+kategori.getId(),null);
                while (c.moveToNext()){
                int id=c.getInt(c.getColumnIndex("id"));
                int kategoriId=c.getInt(c.getColumnIndex("kategori_id"));
                String ad=c.getString(c.getColumnIndex("ad"));
                String resim=c.getString(c.getColumnIndex("resim"));
                String malzemeler=c.getString(c.getColumnIndex("malzemeler"));
                String aciklama=c.getString(c.getColumnIndex("aciklama"));
                int pSuresi=c.getInt(c.getColumnIndex("pisirme_suresi"));
                int hSuresi=c.getInt(c.getColumnIndex("hazirlama_suresi"));
                int kisiSayisi=c.getInt(c.getColumnIndex("kisi_sayisi"));
                int resimId=getResources().getIdentifier(resim,"drawable",getPackageName());
                tarifler.add(new Tarif(id,kategoriId,ad,resimId,malzemeler,aciklama,pSuresi,hSuresi,kisiSayisi));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*tarifler.add(new Tarif(
                1,1,"Ad 1",R.drawable.salata,
                "malzeme1, malzeme2, malzeme3",
                "Tarif Açıklaması",
                30,5,5
        ));
        tarifler.add(new Tarif(
                2,1,"Ad 2",R.drawable.salata,
                "malzeme1, malzeme2, malzeme3",
                "Tarif Açıklaması",
                30,5,5
        ));
        tarifler.add(new Tarif(
                3,1,"Ad 3",R.drawable.salata,
                "malzeme1, malzeme2, malzeme3",
                "Tarif Açıklaması",
                30,5,5
        ));
        tarifler.add(new Tarif(
                4,1,"Ad 4",R.drawable.salata,
                "malzeme1, malzeme2, malzeme3",
                "Tarif Açıklaması",
                30,5,5
        ));
        tarifler.add(new Tarif(
                5,1,"Ad 5",R.drawable.salata,
                "malzeme1, malzeme2, malzeme3",
                "Tarif Açıklaması",
                30,5,5
        ));*/

        listView = findViewById(R.id.listViewTarifler);
        adapter_tarif = new Adapter_Tarif(getApplicationContext(),tarifler);
        listView.setAdapter(adapter_tarif);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),TarifDetayActivity.class);
                intent.putExtra("tarif",tarifler.get(position));
                startActivity(intent);
                //tarife rıklanınca tarifdetay sayfasında ilgili başlığa alt tarifi detaylıca görüntülemek için
                //intent ile ilgili activity sayfasını açtık.
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
