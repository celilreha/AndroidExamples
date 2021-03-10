package com.celilreha.json_parcalama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void nesneEkle(String baslik) {
        TextView textView = new TextView(getApplicationContext());
        textView.setText(baslik);
        textView.setTextSize(24);
        linearLayout.addView(textView);

    }
    public static String convertStreamToString(InputStream is)
            throws IOException {
        Writer writer = new StringWriter();

        char[] buffer = new char[2048];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is,
                    "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }
        String text = writer.toString();
        return text;
    }

    public String dosyaOku(String dosyaAdi){
        String metin = "";
        try {
            InputStream is =  getAssets().open(dosyaAdi);
            metin = convertStreamToString(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return metin;
    }

    LinearLayout linearLayout;
    ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        //nesneEkle("DENEME");
        String yazi = dosyaOku("dosya.txt");

        try {
            JSONObject jsonObject = new JSONObject(yazi);
            JSONArray jsonArray = jsonObject.optJSONArray("ogrenciler");
            for (int i=0; i<jsonArray.length();i++){
                JSONObject ogrenci = jsonArray.optJSONObject(i);
                Ogrenci ogr = new Ogrenci();
                ogr.setAd(ogrenci.getString("ad"));
                ogr.setSoyad(ogrenci.getString("soyad"));
                ogr.setYas(ogrenci.getInt("yas"));
                ogrenciler.add(ogr);

                nesneEkle(ogr.getAd());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
