package com.example.lab12_toast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonShowToast = findViewById(R.id.buttonShowToast);
        buttonShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Showing the toast message
                Toast.makeText(MainActivity.this, "This is a Toast message", Toast.LENGTH_LONG).show();
            }
        });
    }
}
