package com.example.turismo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {

    MediaPlayer cancionInicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        cancionInicion = MediaPlayer.create(this,R.raw.cascada);
        cancionInicion.start();

        TimerTask inicio= new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(splash.this,Home.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo =new Timer();
        tiempo.schedule(inicio,8000);


    }
}