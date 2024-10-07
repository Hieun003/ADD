package com.example.chuyen_doi_activity.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuyen_doi_activity.R;
import com.example.chuyen_doi_activity.adapter.CategoryAdapter;
import com.example.chuyen_doi_activity.model.Category;

import java.util.ArrayList;

public class activity_course_list extends AppCompatActivity {

//    RecyclerView courseListView;
    RecyclerView rvCategory;
    CategoryAdapter adapter;
    ArrayList<Category> listCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_list);
        rvCategory = findViewById(R.id.rv_category);
        listCategory = new ArrayList<>();
        listCategory.add(new Category(1, "Con gái",R.drawable.ic_launcher_foreground));
        listCategory.add(new Category(2, "Con trai",R.drawable.ic_launcher_foreground));
        listCategory.add(new Category(3, "Công sở",R.drawable.ic_launcher_foreground));
        listCategory.add(new Category(4, "Cười 18",R.drawable.ic_launcher_foreground));
        listCategory.add(new Category(5, "Cực hài",R.drawable.ic_launcher_foreground));
        listCategory.add(new Category(6, "Dân gian",R.drawable.ic_launcher_foreground));
//        listCategory.add(new Category(R.drawable.ic_launcher_foreground, "Gia đình"));
//        listCategory.add(new Category(R.drawable.ic_launcher_foreground, "Giao thông"));
//        listCategory.add(new Category(R.drawable.ic_launcher_foreground, "Học sinh"));
//        listCategory.add(new Category(R.drawable.ic_launcher_foreground, "Giáo viên"));
//        listCategory.add(new Category(R.drawable.ic_launcher_foreground, "Xã hội"));
//        listCategory.add(new Category(R.drawable.ic_launcher_foreground, "Đời sống"));

        adapter = new CategoryAdapter(listCategory, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rvCategory.setAdapter(adapter);
        rvCategory.setLayoutManager(linearLayoutManager);
//        courseListView = findViewById(R.id.recycle);
//
//        // Data for course list
//        String[] courses = {
//                "Công nghệ Phần mềm",
//                "Web",
//                "Di động",
//                "Giao diện",
//                "Mạng máy tính",
//                "Hệ điều hành"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
//        courseListView.setAdapter(adapter);
//
//        courseListView.setOnClickListener((parent, view, position, id) -> {
//            String selectedCourse = courses[position];
//            Toast.makeText(activity_course_list.this, "Bạn đã chọn: " + selectedCourse, Toast.LENGTH_SHORT).show();
//        });
    }
}