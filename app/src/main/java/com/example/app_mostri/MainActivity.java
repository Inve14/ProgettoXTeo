package com.example.app_mostri;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ImageButton map = findViewById(R.id.map);
         ImageButton profile = findViewById(R.id.profile);
         ImageButton rank = findViewById(R.id.rank);

        map.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, Mappa.class, null).commit();
        });

        profile.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, Profilo.class, null).commit();
        });

        rank.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, Classifica.class, null).commit();
        });


    }
}