package com.example.vasundhara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.vasundhara.adapters.SquareAdapter;

import java.util.ArrayList;
import java.util.List;

public class blinkSecond extends AppCompatActivity {
    private GridView gridView;
    private int gridSize; // Number of squares to display

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blink_second);

        gridView = findViewById(R.id.gridView);

        // Get the input from the first screen



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String gridSize = extras.getString("input",null); // Fetch the input value, defaulting to 0 if not found
            // Now you have gridSize value to set up the grid
            int gridsizeint = Integer.parseInt(gridSize);
            Toast.makeText(this, ""+gridsizeint, Toast.LENGTH_SHORT).show();
            setupGridView(gridsizeint);
        }


    }
    private void setupGridView(int gridSize) {
        // Create a list of dummy data for the grid (16 items for 4x4 grid)
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < gridSize * gridSize; i++) {
            dataList.add("Square " + i);
        }

        SquareAdapter adapter = new SquareAdapter(this, gridSize);
        gridView.setNumColumns(gridSize); // Set the number of columns
        gridView.setAdapter(adapter);
    }
}