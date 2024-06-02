package com.example.temp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText celsiusInput = findViewById(R.id.celsiusInput);
        Button convertButton = findViewById(R.id.convertButton);
        final TextView fahrenheitResult = findViewById(R.id.fahrenheitResult);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double celsius = Double.parseDouble(celsiusInput.getText().toString());
                double fahrenheit = celsiusToFahrenheit(celsius);
                fahrenheitResult.setText(String.format("%.2f Fahrenheit", fahrenheit));
            }
        });
    }
    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
}
