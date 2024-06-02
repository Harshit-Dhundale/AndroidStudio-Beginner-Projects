package com.example.dob;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSpinner();

        Button submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(view -> handleSubmitButton());
    }

    private void setupSpinner() {
        Spinner stateSpinner = findViewById(R.id.stateSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.states_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(adapter);
    }

    public void showDatePickerDialog(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (datePicker, year, month, day) -> {
                    EditText dob = findViewById(R.id.dob);
                    // Month is indexed from 0, so add 1 for clarity.
                    dob.setText(String.format(Locale.getDefault(), "%04d-%02d-%02d", year, month + 1, day));
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void handleSubmitButton() {
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        EditText address = findViewById(R.id.address);
        RadioGroup genderGroup = findViewById(R.id.genderGroup);
        int selectedId = genderGroup.getCheckedRadioButtonId();
        RadioButton genderButton = findViewById(selectedId);
        EditText age = findViewById(R.id.age);
        EditText dob = findViewById(R.id.dob);
        Spinner stateSpinner = findViewById(R.id.stateSpinner);

        String genderText = "Not selected";
        if (genderButton != null) {
            genderText = genderButton.getText().toString();
        }

        String result = "Username: " + username.getText().toString() +
                "\nPassword: " + password.getText().toString() +
                "\nAddress: " + address.getText().toString() +
                "\nGender: " + genderText +
                "\nAge: " + age.getText().toString() +
                "\nDOB: " + dob.getText().toString() +
                "\nState: " + stateSpinner.getSelectedItem().toString();

        TextView resultText = findViewById(R.id.resultText);
        resultText.setText(result);
    }
}
