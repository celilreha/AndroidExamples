package com.celilreha.resimuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView ivResim;
    TextView tvBaslik;
    Button btnGeri, btnRastgele, btnIleri;

    int sayi = 0;
    ArrayList<Resim> resimler = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivResim = findViewById(R.id.ivResim);
        tvBaslik = findViewById(R.id.tvBaslik);
        btnGeri = findViewById(R.id.btnGeri);
        btnRastgele = findViewById(R.id.btnRastgele);
        btnIleri = findViewById(R.id.btnIleri);

        resimler.add(new Resim(1, "Başlık 1", R.drawable.resim1));
        resimler.add(new Resim(2, "Başlık 2", R.drawable.resim2));
        resimler.add(new Resim(3, "Başlık 3", R.drawable.resim3));
        resimler.add(new Resim(4, "Başlık 4", R.drawable.resim4));
        resimler.add(new Resim(5, "Başlık 5", R.drawable.resim5));
        resimler.add(new Resim(6, "Başlık 6", R.drawable.resim6));

        ivResim.setImageResource(resimler.get(0).getResim());
        tvBaslik.setText(resimler.get(0).getResimBaslik());

        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sayi != 0)
                    sayi--;
                else
                    sayi = 5;
                ivResim.setImageResource(resimler.get(sayi).getResim());
                tvBaslik.setText(resimler.get(sayi).getResimBaslik());
            }
        });

        btnRastgele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                sayi = r.nextInt(resimler.size());
                ivResim.setImageResource(resimler.get(sayi).getResim());
                tvBaslik.setText(resimler.get(sayi).getResimBaslik());
            }
        });

        btnIleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sayi < resimler.size() - 1)
                    sayi++;
                else
                    sayi = 0;
                ivResim.setImageResource(resimler.get(sayi).getResim());
                tvBaslik.setText(resimler.get(sayi).getResimBaslik());
            }
        });

    }
}
