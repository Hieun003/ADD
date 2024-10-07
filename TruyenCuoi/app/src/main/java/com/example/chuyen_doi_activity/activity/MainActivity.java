package com.example.chuyen_doi_activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chuyen_doi_activity.R;

public class MainActivity extends AppCompatActivity {
    Button buttonDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonDanhSach = findViewById(R.id.buttonDanhSach);


        buttonDanhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent manhinh_2 = new Intent(MainActivity.this, activity_course_list.class);
                startActivity(manhinh_2);
            }
        });
    }
}