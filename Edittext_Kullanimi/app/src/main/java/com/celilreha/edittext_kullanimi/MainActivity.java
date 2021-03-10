package com.celilreha.edittext_kullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etYazi;
    Button btnGonder;
    TextView tvYazi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etYazi =findViewById(R.id.etYazi);
        tvYazi = findViewById(R.id.tvYazi);
        btnGonder = findViewById(R.id.btnGonder);

        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvYazi.setText(etYazi.getText().toString());
            }
        });
    }
}
