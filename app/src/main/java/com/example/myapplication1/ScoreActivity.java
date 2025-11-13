package com.example.myapplication1;

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
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        gamesPlayed = findViewById(R.id.totalGames);
        correctAttempts = findViewById(R.id.correct);
        back = findViewById(R.id.button4);
        back.setOnClickListener(view -> finish());


        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            int totalGames = extras.getInt("TOTAL_GAMES", 0);
            int totalCorrect = extras.getInt("TOTAL_CORRECT_ATTEMPTS", 0);
            gamesPlayed.setText(String.valueOf(totalGames));
            correctAttempts.setText(String.valueOf(totalCorrect));
        }


    }
}