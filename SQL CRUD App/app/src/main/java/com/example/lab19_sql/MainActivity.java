package com.example.lab19_sql;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.database.Cursor;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText itemEditText;
    Button addButton, updateButton, deleteButton;
    ListView itemsListView;
    ArrayAdapter<String> itemArrayAdapter;
    DatabaseHelper databaseHelper;
    int selectedItemId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemEditText = findViewById(R.id.itemEditText);
        addButton = findViewById(R.id.addButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);
        itemsListView = findViewById(R.id.itemsListView);
        databaseHelper = new DatabaseHelper(MainActivity.this);

        showItemsOnListView();

        addButton.setOnClickListener(view -> {
            databaseHelper.addItem(itemEditText.getText().toString());
            showItemsOnListView();
            itemEditText.setText("");
            Toast.makeText(MainActivity.this, "Item added", Toast.LENGTH_SHORT).show();
        });

        itemsListView.setOnItemClickListener((adapterView, view, position, id) -> {
            selectedItemId = position + 1;
            String itemSelected = (String) itemsListView.getItemAtPosition(position);
            itemEditText.setText(itemSelected);
        });

        updateButton.setOnClickListener(view -> {
            if (selectedItemId > 0) {
                databaseHelper.updateItem(selectedItemId, itemEditText.getText().toString());
                showItemsOnListView();
                Toast.makeText(MainActivity.this, "Item updated", Toast.LENGTH_SHORT).show();
                itemEditText.setText("");
                selectedItemId = -1;
            } else {
                Toast.makeText(MainActivity.this, "Please select an item to update", Toast.LENGTH_SHORT).show();
            }
        });

        deleteButton.setOnClickListener(view -> {
            if (selectedItemId > 0) {
                databaseHelper.deleteItem(selectedItemId);
                showItemsOnListView();
                Toast.makeText(MainActivity.this, "Item deleted", Toast.LENGTH_SHORT).show();
                itemEditText.setText("");
                selectedItemId = -1;
            } else {
                Toast.makeText(MainActivity.this, "Please select an item to delete", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showItemsOnListView() {
        ArrayList<String> itemList = new ArrayList<>();
        Cursor data = databaseHelper.getAllItems();
        if (data.moveToFirst()) {
            int indexName = data.getColumnIndex("name");
            if (indexName != -1) {
                do {
                    itemList.add(data.getString(indexName));
                } while (data.moveToNext());
            }
        }
        itemArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        itemsListView.setAdapter(itemArrayAdapter);
        data.close();
    }
}
