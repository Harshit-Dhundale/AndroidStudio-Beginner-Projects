package com.example.bouncingballanimation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageBall = findViewById(R.id.imageBall);

        // Create a ValueAnimator that oscillates between two values
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1000f);
        valueAnimator.addUpdateListener(animation -> {
            float value = (Float) animation.getAnimatedValue();
            imageBall.setTranslationY(value);
        });

        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(700);

        // Repeat the animation indefinitely and reverse on each repeat
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);

        valueAnimator.start();
    }
}
