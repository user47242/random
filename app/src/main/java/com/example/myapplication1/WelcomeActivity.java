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

    private EditText playerNameEditText,age;
    private Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        playerNameEditText = findViewById(R.id.playerNameEditText);
        startGameButton = findViewById(R.id.startGameButton);
        age = findViewById(R.id.editTextText);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = playerNameEditText.getText().toString().trim();
                String playerAge = age.getText().toString().trim();


                if (playerName.isEmpty() || playerAge.isEmpty()) {
                    Toast.makeText(WelcomeActivity.this, "Please enter both Name and Age", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    intent.putExtra("PLAYER_NAME", playerName);
                    intent.putExtra("PLAYER_AGE", playerAge);
                    startActivity(intent);
                }
            }
        });
    }
}