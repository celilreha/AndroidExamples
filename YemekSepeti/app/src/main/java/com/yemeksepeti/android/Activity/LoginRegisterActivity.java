package com.yemeksepeti.android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.HashMap;
import java.util.Map;

public class LoginRegisterActivity extends AppCompatActivity {
    EditText inputPass,inputEmail;
    Button buttonLogin_SignIn;
    TextView textSignIn,textWelcome;
    String action;

    StringRequest stringRequest;
    RequestQueue requestQueue;
    public boolean makeLogin(final String email, final String pass){
        boolean b=true;
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
                            Log.d("RESPONSE_STR",response);
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
                hashMap.put("email",email);
                hashMap.put("password",pass);
                return super.getParams();
            }
        };
        return b;
    }
    public boolean makeRegister(final String email,final String pass){
        boolean b=true;
        stringRequest = new StringRequest(
                Request.Method.POST,
                "https://gungor.online/apps/yemeksepeti_api/kayit.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

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
                hashMap.put("email",email);
                hashMap.put("password",pass);
                return super.getParams();
            }
        };
        return b;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        this.getSupportActionBar().hide();

        requestQueue = new Volley().newRequestQueue(getApplicationContext());

        action = getIntent().getStringExtra("action");
        inputEmail=findViewById(R.id.inputEmail);
        inputPass=findViewById(R.id.inputPass);
        buttonLogin_SignIn = findViewById(R.id.buttonLogin_SignIn);
        textSignIn = findViewById(R.id.textSignIn);
        textWelcome = findViewById(R.id.textWelcome);
        if ("sign_in".equals(action)){
            textWelcome.setText("Please Sign In");
            buttonLogin_SignIn.setText("Sign In");
            textSignIn.setText("Please fill these for Sign In");

        }else if("sign_up".equals(action)){
            textWelcome.setText("Please Sign Up");
            buttonLogin_SignIn.setText("Sign Up");
            textSignIn.setText("Please fill these for Sign Up");
        }
        buttonLogin_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = false;
                if(!inputEmail.getText().toString().isEmpty() && !inputPass.getText().toString().isEmpty()){
                    if ("sign_in".equals(action)){
                        b=makeLogin(inputEmail.getText().toString(),inputPass.getText().toString());
                        if(b){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(),"Giriş Başarısız",Toast.LENGTH_SHORT).show();
                        }

                    }else if("sign_up".equals(action)){
                        b=makeRegister(inputEmail.getText().toString(),inputPass.getText().toString());
                        if(b){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(),"Kayıt Başarısız",Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Email ya da şifre boş bırakılamaz",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
