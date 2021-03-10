package com.celilreha.fragmentkullanimi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.celilreha.fragmentkullanimi.Fragment.Fragment1;
import com.celilreha.fragmentkullanimi.Fragment.Fragment2;
import com.celilreha.fragmentkullanimi.R;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    FrameLayout frameLayout;
/*
fragment sınıfı, kendi başına çalışan bir yapı değildir.
bir fragment çalışabilmesi için bir activity sayfasına bağımlıdır.
fragment uygulamanın daha seri ve performanslı çalışabilmesi için kullanılan bir yapıdır.
fragment activity sayfalrının açılış kapanış gibi işlemlerini yapmak yerine
tek bir activity sayfasında birden fazla layout görüntüsü gösterebilmek için kullanılan bir yapıdır.
fragmentların activityler gibi yaşam döngüleri bulunur.
onCreateView bir fragment nesnesinin oluşturma zamanını
onViewCreated ise fragment arayüzünün oluşturulduğu zamanı temsil eder.
 */
    public void changeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.frameLayout);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new Fragment1());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new Fragment2());

            }
        });
    }
}
