package com.example.ascii;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView asciiResultText;  // Declare the TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputEditText = findViewById(R.id.inputEditText);
        asciiResultText = findViewById(R.id.asciiResultText);

        findViewById(R.id.okButton).setOnClickListener(v -> {
            String input = inputEditText.getText().toString();
            asciiResultText.setText(getAsciiValues(input));
        });
    }

    private String getAsciiValues(String input) {
        StringBuilder asciiResult = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (Character.isLetterOrDigit(character)) {
                asciiResult.append(character).append(": ").append((int) character).append("\n");
            }
        }
        return asciiResult.toString();
    }
}
