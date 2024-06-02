package com.example.lab18_slide;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private float startY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure 'activity_main' is the correct layout file

        imageView = findViewById(R.id.imageView);  // Make sure 'imageView' is the correct ID in your layout

        imageView.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // When the user presses down, record the start position
                    startY = event.getY();
                    return true;
                case MotionEvent.ACTION_MOVE:
                    // Calculate the distance moved
                    float deltaY = event.getY() - startY;

                    // Move the view
                    imageView.setTranslationY(imageView.getTranslationY() + deltaY);

                    // Update the start position
                    startY = event.getY();
                    return true;
            }
            return false;
        });
    }
}
