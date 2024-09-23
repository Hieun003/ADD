package com.example.caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textViewResult,textViewHistory;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnDivide,btnSubtract, btnClear,btnEqual,btnAdd, btnMultiply;
    String number=null;
    String resulHistory=null;
    double FirstNumber=0, LastNumber = 0;
    String status;
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

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnDivide = findViewById(R.id.btnDivide);
        btnEqual = findViewById(R.id.btnEqual);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnAdd = findViewById(R.id.btnAdd);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnClear = findViewById(R.id.btnClear);

        textViewResult = findViewById(R.id.textViewResult);
        textViewHistory = findViewById(R.id.textViewHistory);

        btn0.setOnClickListener(view -> anhxa("0"));
        btn1.setOnClickListener(view -> anhxa("1"));
        btn2.setOnClickListener(view -> anhxa("2"));
        btn3.setOnClickListener(view -> anhxa("3"));
        btn4.setOnClickListener(view -> anhxa("4"));
        btn5.setOnClickListener(view -> anhxa("5"));
        btn6.setOnClickListener(view -> anhxa("6"));
        btn7.setOnClickListener(view -> anhxa("7"));
        btn8.setOnClickListener(view -> anhxa("8"));
        btn9.setOnClickListener(view -> anhxa("9"));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewResult.getText().toString() + " +");
                FirstNumber = Double.parseDouble(textViewResult.getText().toString());
                number=null;
                status="Add";
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewResult.getText().toString() + " -");
                FirstNumber = Double.parseDouble(textViewResult.getText().toString());
                number=null;
                status="Subtract";
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewResult.getText().toString() + " *");
                FirstNumber = Double.parseDouble(textViewResult.getText().toString());
                number=null;
                status="Multiply";
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHistory.setText(textViewResult.getText().toString() + " /");
                FirstNumber = Double.parseDouble(textViewResult.getText().toString());
                number=null;
                status="Divide";
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status=="Add"){
                    Add();
                }
                else if (status=="Subtract"){
                    Subtract();
                }
                else if (status=="Multiply"){
                    Mulpily();
                }
                else if (status=="Divide"){
                    Divide();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                FirstNumber=0;
                LastNumber=0;
            }
        });
    }
    private void anhxa(String view ){
        if(number==null){
            number = view;
        }
        else{
            number=number+view;
        }
        textViewResult.setText(String.valueOf(number));
    }
    private void Add(){

                LastNumber = Double.parseDouble(textViewResult.getText().toString());
                FirstNumber = LastNumber + FirstNumber;

            number=null;
            textViewResult.setText(String.valueOf(FirstNumber));
    }
    private void Subtract(){

            LastNumber = Double.parseDouble(textViewResult.getText().toString());
            FirstNumber = FirstNumber-LastNumber ;

        number=null;
        textViewResult.setText(String.valueOf(FirstNumber));
    }
    private void Mulpily(){

            LastNumber = Double.parseDouble(textViewResult.getText().toString());
            FirstNumber = LastNumber * FirstNumber;

        number=null;
        textViewResult.setText(String.valueOf(FirstNumber));
    }
    private void Divide(){

            LastNumber = Double.parseDouble(textViewResult.getText().toString());
            if(LastNumber==0){
                textViewResult.setText("Can't divide by 0");
                number=null;
            }
            else{
                FirstNumber = FirstNumber / LastNumber  ;
                number=null;
                textViewResult.setText(String.valueOf(FirstNumber));
            }
//            FirstNumber = FirstNumber / LastNumber  ;
//            number=null;
//            textViewResult.setText(String.valueOf(FirstNumber));
    }
}