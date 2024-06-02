package com.example.dynamicviewsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout containerLayout;
    private List<EditText> editTextList = new ArrayList<>();
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        containerLayout = findViewById(R.id.container_layout);
        Button addButton = findViewById(R.id.add_button);
        Button showButton = findViewById(R.id.show_button);
        resultText = findViewById(R.id.result_text);

        addButton.setOnClickListener(v -> addEditText());
        showButton.setOnClickListener(v -> showAllTexts());
    }

    private void addEditText() {
        EditText editText = new EditText(this);
        editText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        containerLayout.addView(editText);
        editTextList.add(editText);
    }

    private void showAllTexts() {
        StringBuilder stringBuilder = new StringBuilder();
        for (EditText editText : editTextList) {
            stringBuilder.append(editText.getText().toString()).append("\n");
        }
        resultText.setText(stringBuilder.toString());
    }
}
