package com.example.newproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtSo1, edtSo2;
    Button btnTong, btnHieu, btnTich, btnThuong, btnMax, btnThoat;
    TextView txtKQ;
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
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        txtKQ = findViewById(R.id.txtKQ);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnMax = findViewById(R.id.btnMax);
        btnThoat = findViewById(R.id.btnThoat);
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(edtSo1.getText().toString());
                int y = Integer.parseInt(edtSo2.getText().toString());
                int kq = x+y;
                txtKQ.setText(String.valueOf(kq));
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(edtSo1.getText().toString());
                int y = Integer.parseInt(edtSo2.getText().toString());
                int kq = x-y;
                txtKQ.setText(String.valueOf(kq));
            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(edtSo1.getText().toString());
                int y = Integer.parseInt(edtSo2.getText().toString());
                int kq = x*y;
                txtKQ.setText(String.valueOf(kq));
            }
        });
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double x = Integer.parseInt(edtSo1.getText().toString());
                double y = Integer.parseInt(edtSo2.getText().toString());
                if(y==0){
                    Toast toast = Toast.makeText(MainActivity.this, "khong the chia cho 0", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    double kq = x/y;
                    txtKQ.setText(String.valueOf(kq));
                }
            }
        });
        btnMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(edtSo1.getText().toString());
                int y = Integer.parseInt(edtSo2.getText().toString());
                txtKQ.setText(String.valueOf(UCLN(x,y)));
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private int UCLN(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return UCLN(b,a%b);
        }
    }
}