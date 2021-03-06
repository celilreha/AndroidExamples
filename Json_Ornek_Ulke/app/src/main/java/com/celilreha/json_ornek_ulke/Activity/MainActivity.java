package com.celilreha.json_ornek_ulke.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.celilreha.json_ornek_ulke.Adapter.Adapter_Ulke;
import com.celilreha.json_ornek_ulke.Model.Ulke;
import com.celilreha.json_ornek_ulke.R;

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
    ListView listView;
    ArrayList<Ulke> ulkeler = new ArrayList<>();
    Adapter_Ulke adapter_ulke;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        String yazi = dosyaOku("dosya.txt");

        try {
            JSONObject jsonObject = new JSONObject(yazi);
            JSONArray jsonArray = jsonObject.optJSONArray("ulkeler");
            for (int i=0;i<jsonArray.length();i++){
                JSONObject object = jsonArray.optJSONObject(i);
                Ulke ulke = new Ulke();
                ulke.setAd(object.getString("ad"));
                ulke.setBaskent(object.getString("baskent"));
                ulke.setParaBirimi(object.getString("parabirimi"));
                ulke.setBayrak(object.getString("bayrak"));
                ulkeler.add(ulke);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        adapter_ulke = new Adapter_Ulke(getApplicationContext(),ulkeler);
        listView.setAdapter(adapter_ulke);

    }
}
