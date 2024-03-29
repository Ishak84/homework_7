package com.geeks.homework_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second, sum;
    private Boolean isOperationClick = false;
    private String operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            first = 0;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        isOperationClick = false;
    }

    @SuppressLint("SetTextI18n")
    public void onOperationClick(View view) {
        if (view.getId() == R.id.btn_plus) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "-";
        } else if (view.getId() == R.id.btn_multiplication) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "*";
        } else if (view.getId() == R.id.btn_division) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "/";
        } else if (view.getId() == R.id.operation_equals) {
            second = Integer.valueOf(textView.getText().toString());
            if (operation.equals("+")) {
                sum = first + second;
                textView.setText(sum.toString());
            } else if (operation.equals("-")) {
                sum = first - second;
                textView.setText(sum.toString());
            } else if (operation.equals("*")) {
                sum = first * second;
                textView.setText(sum.toString());
            } else if (operation.equals("/")) {
                if (second == 0) {
                    textView.setText("Error");
                }else
                {
                    sum=first/second;
                    textView.setText(sum.toString());
                }
            }
        }
        isOperationClick = true;
    }
}