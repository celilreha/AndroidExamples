package com.celilreha.videoview_kullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);

        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample);
        controller= new MediaController(this);
        controller.setAnchorView(videoView);
        videoView.setVideoURI(uri);
        videoView.setMediaController(controller);
        videoView.start();


        //Uri.parse içerisine eklenen değerler belirli bir formata dönüştürmak için kullanılır

        /*
        mediacontroller sınıfı videoview nesnesini durdurabilmek, ilerletmek, geri almak, devam ettirmek için kullanılır.

        mediacontroller sınıdını videoview nesnesine bağlayabilmek için setAnchorView metodu kullanılır.
         */
    }
}
