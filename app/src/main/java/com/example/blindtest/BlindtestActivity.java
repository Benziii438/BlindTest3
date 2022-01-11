package com.example.blindtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlindtestActivity extends AppCompatActivity {

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blindtest);


        // recuperer l'extra NomChanson
       String nomChanson = getIntent().getStringExtra("NomChanson");

       Log.d("TextDebug",nomChanson);


        // liste de fausses musique

        List<String> faussesMusiques = new ArrayList<>();
        faussesMusiques.add("Pitakara");
        faussesMusiques.add("Los Del mondos");
        faussesMusiques.add("True love");
        faussesMusiques.add("Filodo");
        faussesMusiques.add("El amor que calor");
        faussesMusiques.add("C++ song");
        faussesMusiques.add("The night of Rust");
        faussesMusiques.add("Ardente de mi cuerpo");

        // generation des fausses musiques

        ConstraintLayout rootLayout = findViewById(R.id.reponse);
        int count = rootLayout.getChildCount();

        // pour chaque element
        for(int i = 0; i < count; i++){
            final Button button = (Button) rootLayout.getChildAt(i);
            int randomNumber = random.nextInt(faussesMusiques.size() - 1);
            String fausseMusiqueGenere = faussesMusiques.get(randomNumber);
            button.setText(fausseMusiqueGenere);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // afficher un toast (un petit message pendant quelques instants)
                    Toast.makeText(getApplicationContext(), "Perdu !", Toast.LENGTH_SHORT).show();
                    button.setEnabled(false);
                    prochaineMusique();
                }
            });
        }

        // choisir au hasard un bouton avec la bonne réponse
        int numeroBonneReponse = random.nextInt(count);
        final Button bonneReponseBtn = (Button) rootLayout.getChildAt(numeroBonneReponse);
        bonneReponseBtn.setText(nomChanson);
        bonneReponseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // afficher un toast lors de la victoire (un petit message pendant quelques instants)
                bonneReponseBtn.setEnabled(false);
                Toast.makeText(getApplicationContext(), "Bravo !", Toast.LENGTH_SHORT).show();
                prochaineMusique();
            }
        });




    }

    public void prochaineMusique() {
        // attendre 2s
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // redirection vers l'ecoute d'une nouvelle musique
                finish();
                startActivity(new Intent(getApplicationContext(), ListenMusicActivity.class));
            }
        }, 2000);








    }
}