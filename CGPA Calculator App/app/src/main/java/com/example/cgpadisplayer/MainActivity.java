package com.example.cgpadisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText regNo, name, mark1, mark2, mark3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regNo = findViewById(R.id.regno);
        name = findViewById(R.id.name);
        mark1 = findViewById(R.id.mark1);
        mark2 = findViewById(R.id.mark2);
        mark3 = findViewById(R.id.mark3);
        Button submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(view -> calculateCGPA());
    }

    private void calculateCGPA() {
        int[] marks = {
                Integer.parseInt(mark1.getText().toString()),
                Integer.parseInt(mark2.getText().toString()),
                Integer.parseInt(mark3.getText().toString())
        };

        float cgpa = 0;
        for (int mark : marks) {
            cgpa += getPoints(getGrade(mark));
        }
        cgpa /= marks.length;

        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("regNo", regNo.getText().toString());
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("cgpa", cgpa);
        intent.putExtra("mark1", Integer.parseInt(mark1.getText().toString()));
        intent.putExtra("mark2", Integer.parseInt(mark2.getText().toString()));
        intent.putExtra("mark3", Integer.parseInt(mark3.getText().toString()));
        startActivity(intent);
    }

    private String getGrade(int mark) {
        if (mark >= 90) return "S";
        else if (mark >= 80) return "A";
        else if (mark >= 70) return "B";
        else if (mark >= 60) return "C";
        else if (mark >= 55) return "D";
        else if (mark >= 50) return "E";
        else return "F";
    }

    private int getPoints(String grade) {
        switch (grade) {
            case "S": return 10;
            case "A": return 9;
            case "B": return 8;
            case "C": return 7;
            case "D": return 6;
            case "E": return 5;
            default: return 0;
        }
    }
}
