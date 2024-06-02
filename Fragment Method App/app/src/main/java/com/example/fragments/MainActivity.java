package com.example.fragments;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentInteractionListener {

    private DisplayFragment displayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayFragment = new DisplayFragment();

        // Add the input fragment on activity creation
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, new InputFragment(), "INPUT_FRAGMENT")
                    .commit();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentDisplayContainer, displayFragment, "DISPLAY_FRAGMENT")
                    .commit();
        }
    }

    @Override
    public void onInputSent(String input) {
        if (displayFragment != null) {
            displayFragment.updateText(input);
        }
    }
}
