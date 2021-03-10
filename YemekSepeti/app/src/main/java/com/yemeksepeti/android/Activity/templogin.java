
package com.yemeksepeti.android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yemeksepeti.android.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class templogin extends AppCompatActivity {

    Button btnAction;
    TextView tvAction,tvTitle;
    EditText etLoginRegisterEmail,etLoginRegisterPassword;
    String action;

    StringRequest stringRequest;
    RequestQueue requestQueue;


    SharedPreferences sp;
    SharedPreferences.Editor spe;


    public void girisYap(final String emailAdresi, final String sifre){
        stringRequest = new StringRequest(
                Request.Method.POST,
                "https://gungor.online/apps/yemeksepeti_api/giris.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if("-1".equals(response)){
                            Toast.makeText(getApplicationContext(),"Kullanıcı adı veya şifre hatalı",Toast.LENGTH_LONG).show();
                        }else if("fail".equals(response)){
                            Toast.makeText(getApplicationContext(),"Bad request",Toast.LENGTH_LONG).show();
                        }else{
                            //Kullanıcı adı ve şifresi doğruysa, JSON PARÇALA
                            //Log.d("RESPONSE_STR",response);


                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray jsonArray = jsonObject.optJSONArray("kullanici");
                                JSONObject kullanici = jsonArray.getJSONObject(0);

                                int id = Integer.parseInt(kullanici.getString("id"));
                                String email = kullanici.getString("email");
                                String adsoyad = kullanici.getString("adsoyad");
                                String fotograf = kullanici.getString("fotograf");
                                int puan = Integer.parseInt(kullanici.getString("puan"));



                                spe.putInt("user_id",id);
                                spe.putString("user_email",email);
                                spe.putString("user_namesurname",adsoyad);
                                spe.putString("user_photo",fotograf);
                                spe.putInt("user_point",puan);
                                spe.putInt("remember",1);
                                spe.commit();

                                /*
                                SharedPreference uygulama önbelleğinde veri depolamak için kullanılan sınıftır.
                                Bu veriler basit veri tipleridir. SharedPreference uygulama tekrar açıldığında
                                hafızadaki değerleri değişken gibi çağırabilir.

                                SharedPrefence nesnesi verileri okumak, SharedPreferences.Editor ise veri eklemek maksatlı kullanılır.

                                SharedPreferences.Editor ise, SharefPreference içerisine veri ekleme, silme ve güncelleme için kullanılır.
                                Değişikliği kaydedebilmek için editörün commit metodu kullanılır.
                                 */

                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }




                        }




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
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("email",emailAdresi);
                hashMap.put("password",sifre);
                return hashMap;
            }
        };

        requestQueue.add(stringRequest);
    }

    public void kayitOl(final String emailAdresi,final String sifre){
        stringRequest = new StringRequest(
                Request.Method.POST,
                "https://gungor.online/apps/yemeksepeti_api/kayit.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if("200".equals(response)){
                            Toast.makeText(getApplicationContext(),"Kullanıcı zaten kayıtlı",Toast.LENGTH_LONG).show();
                        }else if("fail".equals(response)){
                            Toast.makeText(getApplicationContext(),"Bad request",Toast.LENGTH_LONG).show();
                        }else{
                            //Log.d("RESPONSE_LOG",response);

                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray jsonArray = jsonObject.optJSONArray("kullanici");
                                JSONObject kullanici = jsonArray.getJSONObject(0);

                                int id = Integer.parseInt(kullanici.getString("id"));
                                String email = kullanici.getString("email");
                                String adsoyad = kullanici.getString("adsoyad");
                                String fotograf = kullanici.getString("fotograf");
                                int puan = Integer.parseInt(kullanici.getString("puan"));



                                spe.putInt("user_id",id);
                                spe.putString("user_email",email);
                                spe.putString("user_namesurname",adsoyad);
                                spe.putString("user_photo",fotograf);
                                spe.putInt("user_point",puan);
                                spe.putInt("remember",1);
                                spe.commit();

                                /*
                                SharedPreference uygulama önbelleğinde veri depolamak için kullanılan sınıftır.
                                Bu veriler basit veri tipleridir. SharedPreference uygulama tekrar açıldığında
                                hafızadaki değerleri değişken gibi çağırabilir.

                                SharedPrefence nesnesi verileri okumak, SharedPreferences.Editor ise veri eklemek maksatlı kullanılır.

                                SharedPreferences.Editor ise, SharefPreference içerisine veri ekleme, silme ve güncelleme için kullanılır.
                                Değişikliği kaydedebilmek için editörün commit metodu kullanılır.
                                 */




                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            //Kayıt başarılı, Kullanıcı ID, Email ve adsoyadı SharedPreferences içerisinde sakla
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }

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
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("email",emailAdresi);
                hashMap.put("password",sifre);
                return hashMap;
            }
        };

        requestQueue.add(stringRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        this.getSupportActionBar().hide();

        requestQueue = new Volley().newRequestQueue(getApplicationContext());


        action = getIntent().getStringExtra("action");

        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        spe = sp.edit();


        btnAction = findViewById(R.id.btnLoginRegisterAction);
        tvAction = findViewById(R.id.tvLoginRegisterAction);
        tvTitle = findViewById(R.id.tvLoginRegisterTitle);
        etLoginRegisterEmail = findViewById(R.id.etLoginRegisterEmail);
        etLoginRegisterPassword = findViewById(R.id.etLoginRegisterPassword);


        if("login".equals(action)){
            tvTitle.setText("Giriş yapın");
            tvAction.setText("Giriş yapabilmek için bilgilerinizi giriniz.");
            btnAction.setText("Giriş");
        }else if("register".equals(action)){
            tvTitle.setText("Kayıt olun");
            tvAction.setText("Kayıt olabilmek için bilgilerinizi giriniz.");
            btnAction.setText("Kayıt");
        }


        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean b = false;

                if(!etLoginRegisterEmail.getText().toString().isEmpty() && !etLoginRegisterPassword.getText().toString().isEmpty()){
                    if("login".equals(action)){
                        girisYap(etLoginRegisterEmail.getText().toString(),etLoginRegisterPassword.getText().toString());
                    }else if("register".equals(action)){
                        kayitOl(etLoginRegisterEmail.getText().toString(),etLoginRegisterPassword.getText().toString());
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Email yada şifre boş geçilemez",Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}
