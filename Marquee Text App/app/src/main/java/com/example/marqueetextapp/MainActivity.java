package com.example.marqueetextapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView marqueeText = findViewById(R.id.marqueeText);
        // Making sure the TextView is focused to start the marquee
        marqueeText.setSelected(true);
    }
}
