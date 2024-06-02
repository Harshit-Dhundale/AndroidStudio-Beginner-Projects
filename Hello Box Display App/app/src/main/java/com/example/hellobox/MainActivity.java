package com.example.hellobox;

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

        final EditText nameEditText = findViewById(R.id.nameEditText);
        Button okButton = findViewById(R.id.okButton);
        final TextView greetingTextView = findViewById(R.id.greetingTextView);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                if (!name.isEmpty()) {
                    String greeting = "Hello, " + name + "!";
                    greetingTextView.setText(greeting);
                } else {
                    greetingTextView.setText("Hello, stranger!");
                }
            }
        });
    }
}
