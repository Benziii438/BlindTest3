package com.example.blindtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Random;

public class ListenMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_music);

        // rendre la musique aléatoire

        // rendre la musique aleatoire
        int[] sons = new int[] {
                R.raw.backpack,
                R.raw.sun_moonlight,
                R.raw.notosa,
                R.raw.les_oiseaux,
                R.raw.papillon_bleu,
                R.raw.rotodo,
                R.raw.sans_commentaire
        };

        // le nom des musiques
        String[] nomMusiques = {
                "Backpack",
                "Moonlight",
                "Notosa",
                "Oiseaux",
                "Papillon bleu",
                "Sans Commentaire",
                "Rotodo"
        };

        // choisir une à partir de ce tableau
        Random random = new Random();
        final int nombreHasard = random.nextInt(sons.length-1);
        int resourceHasard = sons[nombreHasard];
        final String nomChanson = nomMusiques[nombreHasard];

        // lancer la musique papillon.wav
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), resourceHasard);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                // creer l'action
                Intent intent = new Intent(getApplicationContext(), BlindtestActivity.class);
                intent.putExtra("NomChanson", nomChanson);

                finish();
                startActivity(intent);

            }
        });


    }
}