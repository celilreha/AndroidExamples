package com.celilreha.yemek_tarifleri.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.celilreha.yemek_tarifleri.Helper.DatabaseHelper;
import com.celilreha.yemek_tarifleri.Model.Kategori;
import com.celilreha.yemek_tarifleri.Model.Tarif;
import com.celilreha.yemek_tarifleri.R;

import java.io.IOException;

public class TarifDetayActivity extends AppCompatActivity {

    Kategori kategori;
    Tarif tarif;
    ImageView ivResim;
    TextView tvHazirlanis,tvKisiSayisi,tvPisirmeSuresi,tvHazirlamaSuresi,
            tvKategori,tvBaslik;
    LinearLayout linearMalzemeler;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;

    public void malzemelerlListele(){
        String [] malzemeler = tarif.getMalzemeler().split(",");
        for (int i=0; i<malzemeler.length; i++){
            CheckBox ch=new CheckBox(this);
            ch.setText(malzemeler[i]);
            linearMalzemeler.addView(ch);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarif_detay);
        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            db=databaseHelper.getReadableDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }


        tvHazirlanis=findViewById(R.id.tvTarifDetayHazirlanis);
        tvKisiSayisi=findViewById(R.id.tvTarifDetayKisiSayisi);
        tvPisirmeSuresi=findViewById(R.id.tvTarifDetayPisirmeSuresi);
        tvHazirlamaSuresi=findViewById(R.id.tvTarifDetayHazirlamaSuresi);
        tvKategori=findViewById(R.id.tvTarifDetayKategori);
        tvBaslik=findViewById(R.id.tvTarifDetayBaslik);
        linearMalzemeler=findViewById(R.id.linearTarifDetayMalzemeler);
        ivResim=findViewById(R.id.ivTarifDetayResim);

        tarif = (Tarif)getIntent().getSerializableExtra("tarif");
        this.setTitle(tarif.getAd());
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String kategoriAdi = "";
        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            db=databaseHelper.getReadableDatabase();
            Cursor c=db.rawQuery("SELECT ad FROM Kategori WHERE id="+tarif.getKategoriId(),null);
            c.moveToNext();
            kategoriAdi=c.getString(c.getColumnIndex("ad"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvHazirlanis.setText(tarif.getAciklama());
        tvKisiSayisi.setText(tarif.getKisiSayisi()+"");
        tvPisirmeSuresi.setText(tarif.getPisirmeSuresi()+" Dk.");
        tvHazirlamaSuresi.setText(tarif.getHazirlamaSuresi()+" Dk.");
        tvKategori.setText(kategoriAdi);
        tvBaslik.setText(tarif.getAd());
        ivResim.setImageResource(tarif.getResim());
        malzemelerlListele();


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            finish();
        }else if(item.getItemId()==R.id.id_favori){

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_favori,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
