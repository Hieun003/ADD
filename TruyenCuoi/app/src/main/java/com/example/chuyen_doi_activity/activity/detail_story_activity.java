package com.example.chuyen_doi_activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chuyen_doi_activity.R;

public class detail_story_activity extends AppCompatActivity {

    TextView categoryName,storyName,detailStory;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_story);

        categoryName = findViewById(R.id.nameCategory);
        storyName = findViewById(R.id.nameStory);
        detailStory = findViewById(R.id.detailStory);
        iv = findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String storyname = intent.getStringExtra("storyName");
        String storydetail = intent.getStringExtra("storyDetail");
        String nameCategory = intent.getStringExtra("categoryName"); // Nhận categoryName
        detailStory.setText(storydetail);
        categoryName.setText(nameCategory);
        storyName.setText(storyname);
    }
}