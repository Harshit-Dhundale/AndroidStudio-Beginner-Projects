package com.example.number2wordconvertor;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numberInput = findViewById(R.id.numberInput);
        final TextView resultText = findViewById(R.id.resultText);

        findViewById(R.id.convertButton).setOnClickListener(v -> {
            String numberStr = numberInput.getText().toString();
            if (!numberStr.isEmpty()) {
                int number = Integer.parseInt(numberStr);
                String word = convertNumberToWord(number);
                resultText.setText(word);
            } else {
                resultText.setText("");
            }
        });
    }

    private String convertNumberToWord(int number) {
        // This is a placeholder for the conversion logic
        // You can implement the conversion logic here or use an existing library
        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        // More conversion logic is needed for numbers over 20
        if (number == 0) {
            return "Zero";
        } else if (number < 10) {
            return units[number];
        } else if (number < 20) {
            // Special cases like eleven, twelve, etc.
            return "Special case handling needed";
        } else if (number < 100) {
            return tens[number / 10] + " " + units[number % 10];
        } else if (number < 1000) {
            return units[number / 100] + " Hundred " + convertNumberToWord(number % 100);
        } else if (number < 10000) {
            return units[number / 1000] + " Thousand " + convertNumberToWord(number % 1000);
        } else {
            return "Number too large";
        }
    }
}
