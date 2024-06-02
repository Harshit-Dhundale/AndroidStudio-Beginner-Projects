package com.example.smssender;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText phoneNumber = findViewById(R.id.phone_number);
        final EditText messageContent = findViewById(R.id.message_content);
        Button sendButton = findViewById(R.id.send_button);

        sendButton.setOnClickListener(v -> {
            String phone = phoneNumber.getText().toString();
            String message = messageContent.getText().toString();
            sendSms(phone, message);
        });
    }

    private void sendSms(String phone, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phone));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
