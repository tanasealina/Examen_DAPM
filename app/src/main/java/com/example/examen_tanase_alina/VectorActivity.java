package com.example.examen_tanase_alina;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;

public class VectorActivity {


    public class vectorActivity extends AppCompatActivity {
        private TextView vectorTextView;
        private TextView minElementTextView;
        private Button backButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_vector);

            vectorTextView = findViewById(R.id.vectorTextView);
            minElementTextView = findViewById(R.id.minElementTextView);
            backButton = findViewById(R.id.backButton);

            final int numElements = getIntent().getIntExtra("numElements", 0);
            int[] vector = generateRandomVector(numElements);
            displayVector(vector);
            int minElement = findMinElement(vector);
            minElementTextView.setText("Element minim: " + minElement);

            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(); // Revenire la activitatea anterioară
                }
            });
        }

        private int[] generateRandomVector(int numElements) {
            int[] vector = new int[numElements];
            Random random = new Random();
            for (int i = 0; i < numElements; i++) {
                vector[i] = random.nextInt(100); // Numere întregi aleatorii între 0 și 99
            }
            return vector;
        }

        private void displayVector(int[] vector) {
            String vectorStr = Arrays.toString(vector);
            vectorTextView.setText("Vector: " + vectorStr);
        }

        private int findMinElement(int[] vector) {
            int min = vector[0];
            for (int i = 1; i < vector.length; i++) {
                if (vector[i] < min) {
                    min = vector[i];
                }
            }
            return min;
        }
    }
}
