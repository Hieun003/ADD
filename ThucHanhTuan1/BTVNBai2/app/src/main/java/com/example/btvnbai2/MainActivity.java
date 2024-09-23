package com.example.btvnbai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView view;
    Button btnRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void initControl(){
        view = findViewById(R.id.view);
        btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int ran = random.nextInt(6) + 1;
                if(ran==1){
                    view.setImageResource(R.drawable.dice1);
                }
                if(ran==2){
                    view.setImageResource(R.drawable.dice2);
                }
                if(ran==3){
                    view.setImageResource(R.drawable.dice3);
                }
                if(ran==4){
                    view.setImageResource(R.drawable.dice4);
                }
                if(ran==5){
                    view.setImageResource(R.drawable.dice5);
                }
                if(ran==6){
                    view.setImageResource(R.drawable.dice6);
                }
            }
        });
    }
}