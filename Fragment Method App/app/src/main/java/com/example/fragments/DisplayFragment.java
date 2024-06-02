package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment {

    private TextView displayText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        displayText = view.findViewById(R.id.displayText);
        return view;
    }

    public void updateText(String text) {
        if (displayText != null) {
            displayText.setText(text);
        }
    }
}
