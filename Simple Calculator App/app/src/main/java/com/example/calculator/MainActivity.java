package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.function.BiFunction;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);

        setupButton(R.id.buttonAdd, (a, b) -> a + b);
        setupButton(R.id.buttonSub, (a, b) -> a - b);
        setupButton(R.id.buttonMul, (a, b) -> a * b);
        setupButton(R.id.buttonDiv, (a, b) -> b == 0 ? Double.NaN : a / b);
    }

    private void setupButton(int buttonId, BiFunction<Double, Double, Double> operation) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(view -> calculate(operation));
    }

    private void calculate(BiFunction<Double, Double, Double> operation) {
        try {
            double num1 = Double.parseDouble(editTextNumber1.getText().toString());
            double num2 = Double.parseDouble(editTextNumber2.getText().toString());
            double result = operation.apply(num1, num2);
            textViewResult.setText("Result: " + (Double.isNaN(result) ? "Cannot divide by zero" : result));
        } catch (NumberFormatException e) {
            textViewResult.setText("Invalid input");
        }
    }
}
