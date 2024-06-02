package com.example.userdetailsapp; // Replace with your actual package name

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userName = findViewById(R.id.userName);
        final EditText password = findViewById(R.id.password);
        final EditText address = findViewById(R.id.address);
        final RadioGroup genderGroup = findViewById(R.id.genderGroup);
        final EditText age = findViewById(R.id.age);
        final EditText email = findViewById(R.id.email);
        final TextView displayData = findViewById(R.id.displayData);

        findViewById(R.id.submit).setOnClickListener(view -> {
            int selectedId = genderGroup.getCheckedRadioButtonId();
            RadioButton selectedGender = findViewById(selectedId);

            String data = "User Name: " + userName.getText().toString() +
                    "\nPassword: " + password.getText().toString() +
                    "\nAddress: " + address.getText().toString() +
                    "\nGender: " + selectedGender.getText().toString() +
                    "\nAge: " + age.getText().toString() +
                    "\nEmail: " + email.getText().toString();

            displayData.setText(data);
        });
    }
}
