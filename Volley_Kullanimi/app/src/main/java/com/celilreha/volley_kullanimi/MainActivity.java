package com.celilreha.volley_kullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPass;
    Button btnGiris,btnKayit;

    RequestQueue requestQueue;
    StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnGiris=findViewById(R.id.btnGiris);
        btnKayit=findViewById(R.id.btnKayit);

        requestQueue = new Volley().newRequestQueue(getApplicationContext());

        btnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringRequest=new StringRequest(
                        Request.Method.POST,
                        "https://gungor.online/apps/ders1_volley/kayit.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("giris_response",response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                ){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> hashMap = new HashMap<>();
                        hashMap.put("email",etEmail.getText().toString());
                        hashMap.put("sifre",etPass.getText().toString());
                        return hashMap;
                    }
                };

                requestQueue.add(stringRequest);

            }
        });
        btnKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                requestQueue.add(stringRequest);
            }
        });
    }
}
