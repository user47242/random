package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {
    private TextView gamesPlayed;
    private TextView correctAttempts;
    private TextView playerNameTextView;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        gamesPlayed = findViewById(R.id.totalGames);
        correctAttempts = findViewById(R.id.correct);
        playerNameTextView = findViewById(R.id.playerNameTextView);
        back = findViewById(R.id.button4);
        back.setOnClickListener(view -> finish());


        Intent intent = getIntent();


            int totalGames = intent.getIntExtra("TOTAL_GAMES", 0);
            int totalCorrect = intent.getIntExtra("TOTAL_CORRECT_ATTEMPTS", 0);
            String playerName = intent.getStringExtra("PLAYER_NAME");
            gamesPlayed.setText(String.valueOf(totalGames));
            correctAttempts.setText(String.valueOf(totalCorrect));
            if (playerName != null && !playerName.isEmpty()) {
                playerNameTextView.setText(playerName);
            } else {
                playerNameTextView.setText(" ");
            }
        }


    }
