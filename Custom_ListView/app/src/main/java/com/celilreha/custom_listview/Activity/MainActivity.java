package com.celilreha.custom_listview.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.celilreha.custom_listview.Adapter.AdapterMuzikAletleri;
import com.celilreha.custom_listview.Model.MuzikAletleri;
import com.celilreha.custom_listview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AdapterMuzikAletleri adapterMuzikAletleri;
    ArrayList<MuzikAletleri> muzikAletleri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        muzikAletleri = new ArrayList<>();
        //int resim, String isim, String aciklama, String renk, String tur, double fiyat
        muzikAletleri.add(new MuzikAletleri(
                R.drawable.baglama,
                "Bağlama",
                "Açıklama",
                "Kahverengi",
                "Telli",
                2500
        ));
        muzikAletleri.add(new MuzikAletleri(
                R.drawable.gitar,
                "Gitar",
                "Açıklama",
                "Siyah",
                "Telli",
                2000
        ));
        muzikAletleri.add(new MuzikAletleri(
                R.drawable.keman,
                "Keman",
                "Açıklama",
                "Kahverengi",
                "Telli",
                4500
        ));
        muzikAletleri.add(new MuzikAletleri(
                R.drawable.klarnet,
                "Klarnet",
                "Açıklama",
                "Siyah",
                "Üflemeli",
                7500
        ));
        muzikAletleri.add(new MuzikAletleri(
                R.drawable.klarnet,
                "Klarnet",
                "Açıklama",
                "Siyah",
                "Üflemeli",
                7500
        ));
        adapterMuzikAletleri = new AdapterMuzikAletleri(muzikAletleri,getApplicationContext());
        listView.setAdapter(adapterMuzikAletleri);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        muzikAletleri.get(position).getIsim(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }
}
