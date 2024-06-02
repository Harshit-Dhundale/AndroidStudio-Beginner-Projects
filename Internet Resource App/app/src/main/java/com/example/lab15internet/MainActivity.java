package com.example.lab15internet;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab15_internet.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText(R.string.result_initial_text);
        fetchData();
    }

    private void fetchData() {
        new Thread(() -> {
            try {
                URL url = new URL("https://en.wikipedia.org/wiki/Android_Studio");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                final String resultText = getString(R.string.data_fetched_success, response.toString());
                runOnUiThread(() -> textViewResult.setText(resultText));
            } catch (Exception e) {

                final String errorText = getString(R.string.fetch_data_error, e.getMessage());
                runOnUiThread(() -> textViewResult.setText(errorText));
            }
        }).start();
    }
}
