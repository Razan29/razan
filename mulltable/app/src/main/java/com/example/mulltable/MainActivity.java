package com.example.mulltable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button b1, b2, b3, b;
    private TextView t1, t2, r, w;
    private EditText a;
    private int cr = 0, cw = 0, count = 0, t11, t22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.editTextText);
        w = findViewById(R.id.textView3);
        r = findViewById(R.id.textView4);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b = findViewById(R.id.button);

        // Basic level
        b1.setOnClickListener(v -> {
            t11 = (int) (Math.random() * 10) + 1;
            t22 = (int) (Math.random() * 10) + 1;
            t1.setText(String.valueOf(t11));
            t2.setText(String.valueOf(t22));
        });

        // Medium level (unlocked after 10 correct)
        b2.setOnClickListener(v -> {
            if (cr >= 10) {
                t11 = (int) (Math.random() * 20) + 1;
                t22 = (int) (Math.random() * 20) + 1;
                t1.setText(String.valueOf(t11));
                t2.setText(String.valueOf(t22));
            } else {
                Toast.makeText(MainActivity.this, "Reach at least 10 correct answers in a row", Toast.LENGTH_SHORT).show();
            }
        });

        // Hard level
        b3.setOnClickListener(v -> {
            t11 = (int) (Math.random() * 100) + 1;
            t22 = (int) (Math.random() * 100) + 1;
            t1.setText(String.valueOf(t11));
            t2.setText(String.valueOf(t22));
        });

        // Submit Answer
        b.setOnClickListener(v -> {
            try {
                int answer = Integer.parseInt(a.getText().toString());
                if (answer == t11 * t22) {
                    count++;
                    cr++;
                    r.setText(String.valueOf(count));
                } else {
                    count = 0;
                    cr = 0;
                    cw++;
                    w.setText(String.valueOf(cw));
                }
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
