package com.example.myapplication1;

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

    private TextView n1,n2,n3,n4,n5,n6,ranNum,points;
    private Button start;
    private int attempts=0,coutplay=0;
    private boolean isRunning = false;
    private Runnable numGenerateRun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        n1=findViewById(R.id.textView);
        n2=findViewById(R.id.textView2);
        n3=findViewById(R.id.textView3);
        n4=findViewById(R.id.textView4);
        n5=findViewById(R.id.textView5);
        n6=findViewById(R.id.textView6);
        ranNum = findViewById(R.id.textView7);
        start = findViewById(R.id.button);
        points = findViewById(R.id.points);
        n1.setText(String.valueOf((int) (Math.random() * 39 + 1)));
        n2.setText(String.valueOf((int) (Math.random() * 39 + 1)));
        n3.setText(String.valueOf((int) (Math.random() * 39 + 1)));
        n4.setText(String.valueOf((int) (Math.random() * 39 + 1)));
        n5.setText(String.valueOf((int) (Math.random() * 39 + 1)));
        n6.setText(String.valueOf((int) (Math.random() * 39 + 1)));
        ranNum.setText("0");
        points.setText("0 out of 6");
        start.setText("start");
        isRunning = false;


        Handler handler = new Handler(Looper.getMainLooper());

        numGenerateRun = new Runnable() {
            @Override
            public void run() {
                if(isRunning){
                    int num= (int) (Math.random() * 39 + 1);
                    ranNum.setText(String.valueOf(num));
                    handler.postDelayed(this,1000);
                }
            }
        };

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(coutplay>=6){
                 return;
             }

                if (!isRunning) {
                    isRunning = true;
                    start.setText("stop");
                    start.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    handler.post(numGenerateRun);
                    coutplay++;


                } else {

                    isRunning = false;
                    String value = ranNum.getText().toString();
                    if (coutplay >= 6) {
                        start.setText("Play Again");
                        start.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));}
                    start.setText("start");
                    start.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

                    if(n1.getText().toString().equals(value))
                    {   attempts++;
                        coutplay++;
                        points.setText(attempts+" out of 6");
                        n1.setBackgroundColor(Color.CYAN);
                    }

                    if(n2.getText().toString().equals(value))
                    {   attempts++;
                        coutplay++;
                        points.setText(attempts+" out of 6");
                        n2.setBackgroundColor(Color.CYAN);
                    }

                    if(n3.getText().toString().equals(value))
                    {   attempts++;
                        coutplay++;
                        points.setText(attempts+" out of 6");
                        n3.setBackgroundColor(Color.CYAN);
                    }

                    if(n4.getText().toString().equals(value))
                    {   attempts++;
                        coutplay++;
                        points.setText(attempts+" out of 6");
                        n4.setBackgroundColor(Color.CYAN);
                    }

                    if(n5.getText().toString().equals(value))
                    {   attempts++;
                        coutplay++;
                        points.setText(attempts+" out of 6");
                        n5.setBackgroundColor(Color.CYAN);
                    }

                    if(n6.getText().toString().equals(value))
                    {   attempts++;
                        coutplay++;
                        points.setText(attempts+" out of 6");
                        n6.setBackgroundColor(Color.CYAN);
                    }

                   }
                }

        });





    }
}
