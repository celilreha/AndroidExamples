package com.celilreha.startactivityforresult_kullanimi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSayfa2;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSayfa2=findViewById(R.id.btnSayfa2);
        et1=findViewById(R.id.et1);
        btnSayfa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);

                startActivityForResult(intent,1);
                /*

            intentten alınan değerlere göre darklı bir sayfayı açan metottur
            startActivity ve startActivityForResult arasında küçük bir fark blunmaktadır.
            startActivity metodu sadece bir sayfayı açmak için kullanılır
            startActivityForResult ise farklı bir sayfayı açmakla kalmayıp o sayfada işlem gerçekleştirilip
            geri git butonuna tıklandığı zaman, önceki sayfaya tekrar geri dönülmesi zamanında
            onActivityResult metodunu tetikler. Yani onActivtyResult eklenirse, bulunduğumuz sayfaya
            gelmeden önce önceki sayfada bir işlem yapıp geri gitmemiz yeterlidir.

            onActivtyResult mantıksal olarak tekrar geri dönülen sayfada bir işlem gerçekleştirebilmek
            için kullanılan bir metottur.

            örnek olarak bir not/günlük uygulaması yaptığımızı düşünün, bu uygulamanın içerisinde MainActivity'de
            not başlıkları olsun. Bu not başlıklarına tıklanınca not detay sayfasına gitsin,

            not detay sayfasında güncelleme ya da not silme işleminin gerçekleştirilebileceği düşünülüyor
            ise, mantıksal olarak bir önceki sayfaya geri döndüğümğzde listede silinen notun gösterilmemesi gerekişr

            onActivtyResult içerisinde eğer bu sayfaya gidip döndüysen listeyi ttekrar güncelle diyebiliriz
            böylelikle veritabanından çektiğimiz değerler onCreate zamanındaki değerler değil de, Activity
            sayfasının tekrar aktif olma zamanında çalışacak işlemi temsil eder.
            */
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if(requestCode==1){
            String yazi= data.getStringExtra("MESAJ");
            et1.setText(yazi);
        }

        }catch (Exception e){

        }

    }
}
