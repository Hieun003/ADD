package com.example.bai4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etName, etHeight, etWeight, edtBMI, edtCD;
    Button btnCalculate;

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
        etName = findViewById(R.id.et_name);
        etHeight = findViewById(R.id.et_height);
        etWeight = findViewById(R.id.et_weight);
        btnCalculate = findViewById(R.id.btn_calculate);
        edtBMI = findViewById(R.id.edtBMI);
        edtCD = findViewById(R.id.edtCD);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caculatorBMI();
            }
        });
    }
    private void caculatorBMI(){
        double H=Double.parseDouble(etHeight.getText().toString());
        double W = Double.parseDouble(etWeight.getText().toString());

        double BMI = W/Math.pow(H,2);
        String chuandoan="";
        if(BMI<18){
            chuandoan = "Bạn gầy";
        }
        else if(BMI<=24.9){
            chuandoan = "Bạn bình thường";
        }
        else if(BMI<=34.9){
            chuandoan = "Bạn béo phì độ 2";
        }
        else{
            chuandoan = "Bạn béo phì độ 3";
        }
        DecimalFormat dcf = new DecimalFormat("#.0");
        edtBMI.setText(dcf.format(BMI));
        edtCD.setText(chuandoan);
    }
}