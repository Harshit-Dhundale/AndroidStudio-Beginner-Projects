package com.example.lab3_bgactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout backgroundView;
    private Button changeBackgroundButton;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundView = findViewById(R.id.backgroundView);
        changeBackgroundButton = findViewById(R.id.changeBackgroundButton);

        changeBackgroundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                backgroundView.setBackgroundColor(color);
            }
        });
    }
}
