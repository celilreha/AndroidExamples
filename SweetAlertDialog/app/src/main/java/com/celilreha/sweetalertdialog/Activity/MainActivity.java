package com.celilreha.sweetalertdialog.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.celilreha.sweetalertdialog.Dialog.Dialog1;
import com.celilreha.sweetalertdialog.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dialog1 dialog1= new Dialog1("baslik","aciklama");
        dialog1.show(getSupportFragmentManager(),null);

    }
}
