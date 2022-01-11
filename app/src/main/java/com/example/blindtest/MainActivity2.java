package com.example.blindtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button playbtn = findViewById(R.id.playbtn);

        // Passez de la mainActivity à ListenMusicActivity
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // stopper l'activité mainActivity
                startActivity(new Intent(getApplicationContext(),ListenMusicActivity.class));
            }
        });
    }
}