package com.celilreha.menu_kullanimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*
    onCreateOptionsMenu metodu res>menu altundaki bir .xml dosyasını toolbar'a bağlamak için kullanılır.

    onOptionsItemSelected ise, menu item'larının tıklama olayını yakaladığı metodu temsil eder
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // getMenuInflater kavramı toolbar'a menuyü bağlamak için kullanılır.
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //tıklanan menu itemlere ait işlemleri gerçekleştirebilmesi için kullanılır.
        switch (item.getItemId()) {
            case R.id.id_email:
                Toast.makeText(
                        getApplicationContext(),
                        "Email",
                        Toast.LENGTH_SHORT
                ).show();
                break;
            case R.id.id_iletisim:
                Toast.makeText(
                        getApplicationContext(),
                        "İletişim",
                        Toast.LENGTH_SHORT
                ).show();
                break;
            case R.id.id_playstore:
                Toast.makeText(
                        getApplicationContext(),
                        "Play Store",
                        Toast.LENGTH_SHORT
                ).show();
                break;
            case R.id.id_ulasim:
                Toast.makeText(
                        getApplicationContext(),
                        "Ulaşım",
                        Toast.LENGTH_SHORT
                ).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
