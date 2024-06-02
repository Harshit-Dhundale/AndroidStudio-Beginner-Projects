package com.example.generalinfo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final EditText addressEditText = findViewById(R.id.address);
        final RadioGroup genderRadioGroup = findViewById(R.id.genderGroup);
        final EditText ageEditText = findViewById(R.id.age);
        final EditText emailEditText = findViewById(R.id.email);
        final TextView displayText = findViewById(R.id.displayText);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender;
                int selectedId = genderRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                if (selectedRadioButton != null) {
                    gender = selectedRadioButton.getText().toString();
                } else {
                    gender = "Not specified";
                }

                String userInfo = "User Name: " + usernameEditText.getText().toString() +
                        "\nPassword: " + passwordEditText.getText().toString() +
                        "\nAddress: " + addressEditText.getText().toString() +
                        "\nGender: " + gender +
                        "\nAge: " + ageEditText.getText().toString() +
                        "\nEmail: " + emailEditText.getText().toString();

                displayText.setText(userInfo);
            }
        });
    }
}
