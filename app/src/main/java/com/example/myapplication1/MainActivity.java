package com.example.myapplication1;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView ranNum,points;
    private TextView[] numberTextViews = new TextView[6];
        private Button start,newButton,score  ;
    private int attempts=0,roundPlayed=0,totalTrue=0,totalGames=1;
    private boolean isRunning = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable numGenerateRun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newButton = findViewById(R.id.button2);
        numberTextViews[0] = findViewById(R.id.textView);
        numberTextViews[1]=findViewById(R.id.textView2);
        numberTextViews[2]=findViewById(R.id.textView3);
        numberTextViews[3]=findViewById(R.id.textView4);
        numberTextViews[4]=findViewById(R.id.textView5);
        numberTextViews[5]=findViewById(R.id.textView6);
        ranNum = findViewById(R.id.textView7);
        start = findViewById(R.id.button);
        points = findViewById(R.id.points);
        score = findViewById(R.id.button3);
        numberTextViews[0].setText(String.valueOf((int) (Math.random() * 39 + 1)));
        numberTextViews[1].setText(String.valueOf((int) (Math.random() * 39 + 1)));
        numberTextViews[2].setText(String.valueOf((int) (Math.random() * 39 + 1)));
        numberTextViews[3].setText(String.valueOf((int) (Math.random() * 39 + 1)));
        numberTextViews[4].setText(String.valueOf((int) (Math.random() * 39 + 1)));
        numberTextViews[5].setText(String.valueOf((int) (Math.random() * 39 + 1)));
        ranNum.setText("0");
        points.setText("0 out of 6");
        start.setText("start");
        isRunning = false;


        numGenerateRun = new Runnable() {
            @Override
            public void run() {
                if(isRunning){
                    int num= (int) (Math.random() * 39 + 1);
                    ranNum.setText(String.valueOf(num));
                    handler.postDelayed(this,100);
                }
            }
        };

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roundPlayed > 6) {
                    start.setText("Play Again");
                    start.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                    return;
                }

                if (!isRunning) {
                    isRunning = true;
                    start.setText("stop");
                    start.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    handler.post(numGenerateRun);
                    roundPlayed++;


                } else {

                    isRunning = false;
                    String value = ranNum.getText().toString();
                    start.setText("start");
                    start.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));



                    for (int i = 0; i < numberTextViews.length; i++) {
                        if (numberTextViews[i].getText().toString().equals(value) &&
                                numberTextViews[i].getCurrentTextColor() != Color.GRAY) {
                            attempts++;
                            numberTextViews[i].setBackgroundColor(Color.CYAN);
                            numberTextViews[i].setTextColor(Color.GRAY);
                            totalTrue++;
                        }

                        points.setText(attempts + " out of 6");


                    }

                    if (roundPlayed < 6) {
                        start.setText("Start");
                        start.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    } else {
                        start.setText("Play Again");
                        start.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                    }
                }
            }
        });

       newButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                   totalGames++;
                   attempts=0;
                   points.setText("0 out of 6");
                   roundPlayed=0;
                   start.setText("start");
                   start.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                   for (int i = 0; i < numberTextViews.length; i++) {
                       numberTextViews[i].setText(String.valueOf((int) (Math.random() * 39 + 1)));
                       numberTextViews[i].setBackgroundColor(Color.WHITE);
                       numberTextViews[i].setTextColor(Color.BLACK);

               }
           }
       });

       score.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
               intent.putExtra("TOTAL_GAMES", totalGames);
               intent.putExtra("TOTAL_CORRECT_ATTEMPTS", totalTrue);

               startActivity(intent);
           }
       });






    }
}
