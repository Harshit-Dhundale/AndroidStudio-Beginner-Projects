package com.example.lab10_radio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected RadioButton ID from the RadioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // Find the RadioButton by the returned ID
                RadioButton radioButton = findViewById(selectedId);

                if (radioButton != null) {
                    Toast.makeText(MainActivity.this, "Selected Fruit: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please select a fruit", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
