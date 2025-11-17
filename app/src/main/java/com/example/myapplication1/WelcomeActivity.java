package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    private EditText playerNameEditText;
    private Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        playerNameEditText = findViewById(R.id.playerNameEditText);
        startGameButton = findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = playerNameEditText.getText().toString().trim();


                if (playerName.isEmpty()) {
                    Toast.makeText(WelcomeActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    intent.putExtra("PLAYER_NAME", playerName);
                    startActivity(intent);
                }
            }
        });
    }
}