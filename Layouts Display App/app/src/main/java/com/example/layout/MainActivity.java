package com.example.layout;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLinearLayout = findViewById(R.id.btnLinearLayout);
        Button btnRelativeLayout = findViewById(R.id.btnRelativeLayout);
        Button btnConstraintLayout = findViewById(R.id.btnConstraintLayout);
        Button btnFrameLayout = findViewById(R.id.btnFrameLayout);
        Button btnGridLayout = findViewById(R.id.btnGridLayout);

        // Set click listeners for each button to switch layouts
        btnLinearLayout.setOnClickListener(view -> setContentView(R.layout.linear_layout));
        btnRelativeLayout.setOnClickListener(view -> setContentView(R.layout.relative_layout));
        btnConstraintLayout.setOnClickListener(view -> setContentView(R.layout.constraint_layout));
        btnFrameLayout.setOnClickListener(view -> setContentView(R.layout.frame_layout));
        btnGridLayout.setOnClickListener(view -> setContentView(R.layout.grid_layout));
    }
}
