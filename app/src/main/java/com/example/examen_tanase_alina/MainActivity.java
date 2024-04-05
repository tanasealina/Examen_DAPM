package com.example.examen_tanase_alina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText numElementsEditText;
    private Button generateVectorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        numElementsEditText = findViewById(R.id.numElementsEditText);
        generateVectorButton = findViewById(R.id.generateVectorButton);

        generateVectorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numElements = Integer.parseInt(numElementsEditText.getText().toString());
                Intent intent = new Intent(MainActivity.this, VectorActivity.class);
                intent.putExtra("numElements", numElements);
                startActivity(intent);
            }
        });
    }
}