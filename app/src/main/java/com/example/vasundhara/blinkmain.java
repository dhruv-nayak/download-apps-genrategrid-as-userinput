package com.example.vasundhara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class blinkmain extends AppCompatActivity {

    Button submit;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blinkmain);

        submit = findViewById(R.id.submit);
        input = findViewById(R.id.input);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(blinkmain.this,blinkSecond.class);
                intent.putExtra("input",input.getText().toString());
                startActivity(intent);
            }
        });
    }
}