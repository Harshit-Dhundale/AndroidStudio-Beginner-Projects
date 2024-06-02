package com.example.cgpadisplayer;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView regNoView, nameView, grade1View, grade2View, grade3View, cgpaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        regNoView = findViewById(R.id.displayRegNo);
        nameView = findViewById(R.id.displayName);
        grade1View = findViewById(R.id.displayGrade1);
        grade2View = findViewById(R.id.displayGrade2);
        grade3View = findViewById(R.id.displayGrade3);
        cgpaView = findViewById(R.id.displayCGPA);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            regNoView.setText("Reg No: " + extras.getString("regNo"));
            nameView.setText("Name: " + extras.getString("name"));

            // Retrieve marks and compute grades
            int mark1 = extras.getInt("mark1");
            int mark2 = extras.getInt("mark2");
            int mark3 = extras.getInt("mark3");

            grade1View.setText("Grade 1: " + getGrade(mark1));
            grade2View.setText("Grade 2: " + getGrade(mark2));
            grade3View.setText("Grade 3: " + getGrade(mark3));

            // Calculate CGPA
            float cgpa = (getPoints(getGrade(mark1)) + getPoints(getGrade(mark2)) + getPoints(getGrade(mark3))) / 3.0f;
            cgpaView.setText("CGPA: " + cgpa);
        }
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
