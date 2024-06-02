package com.example.lab1_string;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView descriptionTextView = findViewById(R.id.description_text_view);
        String description = getString(R.string.description);
        descriptionTextView.setText(description);
    }
}


