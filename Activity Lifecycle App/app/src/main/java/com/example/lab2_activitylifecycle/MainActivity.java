package com.example.lab2_activitylifecycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logAndAppend("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logAndAppend("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logAndAppend("onDestroy");
    }

    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, lifecycleEvent);
        TextView textView = findViewById(R.id.lifecycle_events);
        textView.append(lifecycleEvent + "\n");
    }
}
