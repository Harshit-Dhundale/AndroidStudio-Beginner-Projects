package com.example.a3menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewForContextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewForContextMenu = findViewById(R.id.textViewForContextMenu);
        registerForContextMenu(textViewForContextMenu);
    }

    // Create option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    // Handle option menu item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.option1) {
            showToast("Option 1 selected");
            return true;
        } else if (item.getItemId() == R.id.option2) {
            showToast("Option 2 selected");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Create context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    // Handle context menu item clicks
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.context1) {
            showToast("Context Option 1 selected");
            return true;
        } else if (item.getItemId() == R.id.context2) {
            showToast("Context Option 2 selected");
            return true;
        }
        return super.onContextItemSelected(item);
    }

    // Show popup menu
    public void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.inflate(R.menu.popup_menu);
        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.popup1) {
                showToast("Popup Option 1 selected");
                return true;
            } else if (item.getItemId() == R.id.popup2) {
                showToast("Popup Option 2 selected");
                return true;
            }
            return false;
        });
        popup.show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
