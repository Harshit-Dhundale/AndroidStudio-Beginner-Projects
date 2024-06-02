package com.example.age;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editTextDateOfBirth, editTextCurrentDate;
    Button buttonCalculate;
    TextView textViewAge;
    Calendar dateOfBirthCal, currentCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDateOfBirth = findViewById(R.id.editTextDateOfBirth);
        editTextCurrentDate = findViewById(R.id.editTextCurrentDate);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewAge = findViewById(R.id.textViewAge);

        dateOfBirthCal = Calendar.getInstance();
        currentCal = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener dateOfBirthListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateOfBirthCal.set(Calendar.YEAR, year);
                dateOfBirthCal.set(Calendar.MONTH, monthOfYear);
                dateOfBirthCal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(editTextDateOfBirth, dateOfBirthCal);
            }
        };

        DatePickerDialog.OnDateSetListener currentDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet (DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                currentCal.set(Calendar.YEAR, year);
                currentCal.set(Calendar.MONTH, monthOfYear);
                currentCal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(editTextCurrentDate, currentCal);
            }
        };

        editTextDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, dateOfBirthListener, dateOfBirthCal
                        .get(Calendar.YEAR), dateOfBirthCal.get(Calendar.MONTH),
                        dateOfBirthCal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        editTextCurrentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, currentDateListener, currentCal
                        .get(Calendar.YEAR), currentCal.get(Calendar.MONTH),
                        currentCal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAge();
            }
        });
    }

    private void updateLabel(EditText editText, Calendar calendar) {
        String format = "dd-MM-yyyy"; // Choose the format you prefer
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        editText.setText(sdf.format(calendar.getTime()));
    }

    private void calculateAge() {
        int yearOfBirth = dateOfBirthCal.get(Calendar.YEAR);
        int yearOfCurrent = currentCal.get(Calendar.YEAR);
        int monthOfBirth = dateOfBirthCal.get(Calendar.MONTH);
        int monthOfCurrent = currentCal.get(Calendar.MONTH);
        int dayOfBirth = dateOfBirthCal.get(Calendar.DAY_OF_MONTH);
        int dayOfCurrent = currentCal.get(Calendar.DAY_OF_MONTH);

        int age = yearOfCurrent - yearOfBirth;
        if (monthOfCurrent < monthOfBirth ||
                (monthOfCurrent == monthOfBirth && dayOfCurrent < dayOfBirth)) {
            age--;
        }

        textViewAge.setText("Your Age: " + age);
    }
}
