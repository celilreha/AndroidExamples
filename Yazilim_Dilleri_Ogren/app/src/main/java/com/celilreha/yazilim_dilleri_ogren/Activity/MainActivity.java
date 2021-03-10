package com.celilreha.yazilim_dilleri_ogren.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.celilreha.yazilim_dilleri_ogren.Adapter.Adapter_Yazilim_Dili;
import com.celilreha.yazilim_dilleri_ogren.Model.Yazilim_Dili;
import com.celilreha.yazilim_dilleri_ogren.R;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Adapter_Yazilim_Dili adapterYazilimDili;
    ArrayList<Yazilim_Dili> yazilimDilleri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.listViewYazilimDilleri);
        yazilimDilleri = new ArrayList<>();
//String baslik, String aciklama, int resim
        yazilimDilleri.add(new Yazilim_Dili("JavaScript","Açıklama",R.drawable.javascript,1));
        yazilimDilleri.add(new Yazilim_Dili("Java","Açıklama",R.drawable.java,2));
        yazilimDilleri.add(new Yazilim_Dili("C#","Açıklama",R.drawable.csharp,3));
        yazilimDilleri.add(new Yazilim_Dili("Kotlin","Açıklama",R.drawable.kotlin,4));
        yazilimDilleri.add(new Yazilim_Dili("Android Programlama","Açıklama",R.drawable.android,5));
        yazilimDilleri.add(new Yazilim_Dili("iOS Programlama","Açıklama",R.drawable.ios,6));
        yazilimDilleri.add(new Yazilim_Dili("PHP","Açıklama",R.drawable.php,7));
        yazilimDilleri.add(new Yazilim_Dili("Python","Açıklama",R.drawable.python,8));

        listView = findViewById(R.id.listViewYazilimDilleri);
        adapterYazilimDili = new Adapter_Yazilim_Dili(getApplicationContext(),yazilimDilleri);
        listView.setAdapter(adapterYazilimDili);

        //listview'ın satırına tıklanma olayı
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),KonularActivity.class);
                intent.putExtra("dil", yazilimDilleri.get(position));
                startActivity(intent);

                /*
                putExtra metodunun birinci argümanı her zaman ikinci sayfada çağırılacak başlık,
                2. argümanı ise gönderilecek veri tipidir.
                Buradaki örnekte gönderdiğimiz veri tipi String yada basit veri tipi değil
                referans veri tipi yani bir class olduğu için o classın içerisinde implements
                Serializable eklememiz gerekti.
                 */
            }
        });
    }

    @Override
    public void onBackPressed() {//geri butonuna tıklama olayı.
        AlertDialog.Builder adb= new AlertDialog.Builder(MainActivity.this);
        adb.setTitle("Uygulama Kapatılsın mı?");
        adb.setMessage("Uygulamayı Kapatmak için Evet'e Tıklayın.");
        adb.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        adb.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        adb.setCancelable(false);
        adb.create();
        adb.show();
    }
}
