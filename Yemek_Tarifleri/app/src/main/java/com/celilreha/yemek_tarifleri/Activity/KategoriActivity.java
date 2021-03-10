package com.celilreha.yemek_tarifleri.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.celilreha.yemek_tarifleri.Adapter.Adapter_Kategori;
import com.celilreha.yemek_tarifleri.Helper.DatabaseHelper;
import com.celilreha.yemek_tarifleri.Model.Kategori;
import com.celilreha.yemek_tarifleri.R;

import java.io.IOException;
import java.util.ArrayList;

public class KategoriActivity extends AppCompatActivity {

    GridView gridViewKategoriler;
    ArrayList<Kategori> kategoriler=new ArrayList<>();
    Adapter_Kategori adapter_kategori;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridViewKategoriler = findViewById(R.id.gridViewKategoriler);

        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            db=databaseHelper.getReadableDatabase();

            /*
            db sınıfının execSQL insert, update, delete işlemlerini gerçekleştirebilir.
            db sınıfının rawQuery metodu ise select sorgusundan dönen tüm satır verilerini listelemek için kullanılır.
             */
            Cursor c=db.rawQuery("SELECT * FROM Kategori",null);
            //select sorgusundan dönen tüm satır verilerini db.rawQuery metodu sayesinde yalalayabiliriz.
            // rawQuery cursor tipinde değer döndürür.(cursor, satır verilerini yakalayabilmek için kullanılan bir sınıftır)
            //c.moveToNext metodu select sorgusundan tüm satırları tek tek gezebilmek için kullanıdğımız bir metottur.
            //bu metot eğer en son satıra gelinmiş ise false döndürür.
            while (c.moveToNext()){
                String ad=c.getString(c.getColumnIndex("ad"));
                String aciklama=c.getString(c.getColumnIndex("aciklama"));
                String resim=c.getString(c.getColumnIndex("resim"));
                int id=c.getInt(c.getColumnIndex("id"));
                int resimId=getResources().getIdentifier(resim,"drawable",getPackageName());
                //getIdentifier kavramı ismiini bildiğimiz bir stringi, belirttiğimiz klasör içerisinde arayıp ilgili referans id'sini bulabilmemiz için kullanılır.
                kategoriler.add(new Kategori(id,ad,aciklama,resimId));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //int id, String ad, String aciklama, int resim
        //kategoriler.add(new Kategori(1,"Çorbalar","Eşsiz Lezzetler",R.drawable.corba));
        /*kategoriler.add(new Kategori(2,"Balıklar","Eşsiz Lezzetler",R.drawable.balik));
        kategoriler.add(new Kategori(3,"Tavuklar","Eşsiz Lezzetler",R.drawable.tavuk));
        kategoriler.add(new Kategori(4,"Etli Yemekler","Eşsiz Lezzetler",R.drawable.etli));
        kategoriler.add(new Kategori(5,"İçecekler","Eşsiz Lezzetler",R.drawable.icecek));
        kategoriler.add(new Kategori(6,"Salatalar","Eşsiz Lezzetler",R.drawable.salata));
        kategoriler.add(new Kategori(7,"Kebaplar","Eşsiz Lezzetler",R.drawable.kebap));*/


        adapter_kategori = new Adapter_Kategori(getApplicationContext(),kategoriler);
        gridViewKategoriler.setAdapter(adapter_kategori);
        gridViewKategoriler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),TariflerActivity.class);
                intent.putExtra("kategori",kategoriler.get(position));
                startActivity(intent);
            }
        });
    }
}
