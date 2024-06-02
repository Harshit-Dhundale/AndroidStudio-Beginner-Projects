package com.example.lab4_imgdisplay;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private boolean isImage1Displayed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.myImageView);
        Button changeImageButton = findViewById(R.id.changeImageButton);

        changeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isImage1Displayed) {
                    imageView.setImageResource(R.drawable.image2);
                } else {
                    imageView.setImageResource(R.drawable.image1);
                }
                isImage1Displayed = !isImage1Displayed;
            }
        });
    }
}
