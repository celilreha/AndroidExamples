package com.celilreha.soru_bankasi.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.celilreha.soru_bankasi.R;
import com.celilreha.soru_bankasi.Helper.DatabaseHelper;
import com.celilreha.soru_bankasi.Model.Konu;
import com.celilreha.soru_bankasi.Model.Soru;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SoruCozumActivity extends AppCompatActivity {

    Konu konu;
    RadioGroup rg;
    Button btnGeriGit,btnIleriGit,btnBitir;
    ImageView ivResim;
    TextView tvSoruBaslik;
    RadioButton rdYanitA,rdYanitB,rdYanitC,rdYanitD;
    ArrayList<Soru> sorular = new ArrayList<>();
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    int soruIndex,soruId;

    char suankiSecilenYanit = ' ';
    HashMap<String,Character> kullaniciYanitlari = new HashMap<>();

    public void secilenYanitiGetir(int soruIndex){
        if (soruIndex<0){
            AlertDialog.Builder adb= new AlertDialog.Builder(SoruCozumActivity.this);
            adb.setTitle("Soru");
            adb.setMessage("İlk Sorudasınız");
            adb.setPositiveButton("Kapat", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            adb.create();
            adb.show();
        }else {
            this.soruIndex = soruIndex;
            tvSoruBaslik.setText(sorular.get(soruIndex).getBaslik());
            rdYanitA.setText(sorular.get(soruIndex).getYanitA());
            rdYanitB.setText(sorular.get(soruIndex).getYanitB());
            rdYanitC.setText(sorular.get(soruIndex).getYanitC());
            rdYanitD.setText(sorular.get(soruIndex).getYanitD());
            soruId = sorular.get(soruIndex).getId();
            if(sorular.get(soruIndex).getResim()!=null){
                //ivResim.setImageResource();
                Glide.with(getApplicationContext()).load(sorular.get(soruIndex).getResim()).into(ivResim);
            }else{
                ivResim.setVisibility(View.GONE);
            }
            char ch = kullaniciYanitlari.get("" + soruId);
            if (ch == 'A') {
                rdYanitA.setChecked(true);
            } else if (ch == 'B') {
                rdYanitB.setChecked(true);
            } else if (ch == 'C') {
                rdYanitC.setChecked(true);
            } else if (ch == 'D') {
                rdYanitD.setChecked(true);
            }

        }
    }

    public void soruyuGetir(int soruIndex){
        this.soruIndex = soruIndex;
        rg.clearCheck();
        if(soruIndex==0){
            btnGeriGit.setVisibility(View.INVISIBLE);
            btnIleriGit.setVisibility(View.VISIBLE);
            btnBitir.setVisibility(View.INVISIBLE);
        }else if(soruIndex==sorular.size()-1){
            btnGeriGit.setVisibility(View.VISIBLE);
            btnIleriGit.setVisibility(View.INVISIBLE);
            btnBitir.setVisibility(View.VISIBLE);
        }else{
            btnIleriGit.setVisibility(View.VISIBLE);
            btnGeriGit.setVisibility(View.VISIBLE);
            btnBitir.setVisibility(View.INVISIBLE);
        }

        tvSoruBaslik.setText(sorular.get(soruIndex).getBaslik());
        rdYanitA.setText(sorular.get(soruIndex).getYanitA());
        rdYanitB.setText(sorular.get(soruIndex).getYanitB());
        rdYanitC.setText(sorular.get(soruIndex).getYanitC());
        rdYanitD.setText(sorular.get(soruIndex).getYanitD());
        soruId = sorular.get(soruIndex).getId();

        if(sorular.get(soruIndex).getResim()!=null){
            //ivResim.setImageResource();
            Glide.with(getApplicationContext()).load(sorular.get(soruIndex).getResim()).into(ivResim);
        }else{
            ivResim.setVisibility(View.GONE);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru_cozum);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        konu = (Konu)getIntent().getSerializableExtra("konu");
        this.setTitle(konu.getKonuAdi());

        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            db = databaseHelper.getReadableDatabase();


            Cursor c = db.rawQuery("select * from Soru where konu_id="+konu.getId(),null);

            while (c.moveToNext()){
                //id,konu_id,resim,başlık,a,b,c,d,yanıt_harf
                sorular.add(new Soru(
                        c.getInt(c.getColumnIndex("id")),
                        c.getInt(c.getColumnIndex("konu_id")),
                        c.getString(c.getColumnIndex("resim")),
                        c.getString(c.getColumnIndex("baslik")),
                        c.getString(c.getColumnIndex("yanit_a")),
                        c.getString(c.getColumnIndex("yanit_b")),
                        c.getString(c.getColumnIndex("yanit_c")),
                        c.getString(c.getColumnIndex("yanit_d")),
                        c.getString(c.getColumnIndex("dogru_yanit_harf")).charAt(0)
                ));
            }




        } catch (IOException e) {
            e.printStackTrace();
        }

        rg=findViewById(R.id.rdGroup);
        btnGeriGit = findViewById(R.id.btnGeriGit);
        btnIleriGit = findViewById(R.id.btnIleriGit);
        btnBitir = findViewById(R.id.btnBitir);
        ivResim = findViewById(R.id.ivSoruResim);
        rdYanitA = findViewById(R.id.rdYanitA);
        rdYanitB = findViewById(R.id.rdYanitB);
        rdYanitC = findViewById(R.id.rdYanitC);
        rdYanitD = findViewById(R.id.rdYanitD);
        tvSoruBaslik = findViewById(R.id.tvSoruBaslik);

        rdYanitA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    suankiSecilenYanit = 'A';
                    kullaniciYanitlari.put(""+soruId,suankiSecilenYanit);
                }
            }
        });

        rdYanitB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    suankiSecilenYanit = 'B';
                    kullaniciYanitlari.put(""+soruId,suankiSecilenYanit);
                }
            }
        });

        rdYanitC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    suankiSecilenYanit = 'C';
                    kullaniciYanitlari.put(""+soruId,suankiSecilenYanit);
                }
            }
        });

        rdYanitD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    suankiSecilenYanit = 'D';
                    kullaniciYanitlari.put(""+soruId,suankiSecilenYanit);
                }
            }
        });



        soruId = sorular.get(0).getId();
        tvSoruBaslik.setText(sorular.get(0).getBaslik());
        rdYanitA.setText(sorular.get(0).getYanitA());
        rdYanitB.setText(sorular.get(0).getYanitB());
        rdYanitC.setText(sorular.get(0).getYanitC());
        rdYanitD.setText(sorular.get(0).getYanitD());

        if(sorular.get(0).getResim()!=null){
            //ivResim.setImageResource();
            Glide.with(getApplicationContext()).load(sorular.get(0).getResim()).into(ivResim);
        }else{
            ivResim.setVisibility(View.GONE);
        }

        btnGeriGit.setVisibility(View.INVISIBLE);
        btnBitir.setVisibility(View.INVISIBLE);


        btnIleriGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soruyuGetir(soruIndex+1);
            }
        });

        btnGeriGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //soruyuGetir(soruIndex-1);
                secilenYanitiGetir(soruIndex-1);
            }
        });

        btnBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int dogruYanitSayisi=0;
                for(String index : kullaniciYanitlari.keySet()){
                    //kullanıcının yanıtları
                    for (int i=0; i<sorular.size(); i++){
                        if(Integer.parseInt(index) == sorular.get(i).getId()){
                            if (kullaniciYanitlari.get(index)==sorular.get(i).getDogruYanit())
                                dogruYanitSayisi++;
                        }
                    }
                    int yanlisYanitSayisi=sorular.size()-dogruYanitSayisi;
                    AlertDialog.Builder adb= new AlertDialog.Builder(SoruCozumActivity.this);
                    adb.setTitle("Yanıtlar");
                    adb.setMessage("Doğru Yanıt Sayısı: "+dogruYanitSayisi+"\n\n"+"Yanlış Yanıt Sayısı: "+yanlisYanitSayisi);
                    adb.setPositiveButton("Kapat", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            //dialog.dismiss();
                        }
                    });
                    adb.create();
                    adb.show();

                    Log.d("Yanıt: ",index+" - "+kullaniciYanitlari.get(index));
                }


            }
        });



    }
}
