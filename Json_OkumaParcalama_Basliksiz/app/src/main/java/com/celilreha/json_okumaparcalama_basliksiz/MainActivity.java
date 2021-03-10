package com.celilreha.json_okumaparcalama_basliksiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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

    ArrayList<Ders> dersler = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String yazi= dosyaOku("dersler.json");

        try {
            JSONArray jsonArray = new JSONArray(yazi);
            for (int i=0; i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Ders ders = new Ders();
                ders.setAd(jsonObject.getString("ad"));
                ders.setSaat(jsonObject.getInt("saat"));
                ders.setSinif(jsonObject.getInt("sinif"));
                dersler.add(ders);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
