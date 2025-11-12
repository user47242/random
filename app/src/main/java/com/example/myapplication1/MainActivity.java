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

    private TextView n1,n2,n3,n4,n5,n6,ranNum;
    private Button start;
    private int count=0;
    private boolean isRunning = false;
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
        Handler handler = new Handler(Looper.getMainLooper());


        start.setText("start");


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isRunning&&count<6) {
                    count++;
                    isRunning = true;
                    start.setText("stop");
                    start.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {

                            while(isRunning)
                            ranNum.setText(String.valueOf((int) (Math.random() * 39 + 1)));


                        }
                    };
                    handler.post(runnable);
                    start.setText("stop");
                   isRunning = true;
                } else {

                    handler.removeCallbacks(Runnable);
                    start.setText("start");
                    isRunning = false;
                }
            }
        });



        n1.setText(String.valueOf((int)(Math.random()*39)+1));
        n2.setText(String.valueOf((int)(Math.random()*39)+1));
        n3.setText(String.valueOf((int)(Math.random()*39)+1));
        n4.setText(String.valueOf((int)(Math.random()*39)+1));
        n5.setText(String.valueOf((int)(Math.random()*39)+1));
        n6.setText(String.valueOf((int)(Math.random()*39)+1));

    }
}
