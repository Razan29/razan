package com.example.game2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {
    private Button back;
    private TextView score, games,general;
    private String name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);

        Intent MainAC= new Intent(ScoreActivity.this,MainActivity.class);
        Intent intent=getIntent();
        String name=intent.getStringExtra("Name");

        general=findViewById(R.id.general);
        games=findViewById(R.id.gamesi);
        score=findViewById(R.id.scorei);
        back=findViewById(R.id.backid);
        general.setText(name+", Your Score Is");
        games.setText("games="+MainActivity.countg);
        score.setText("score="+MainActivity.countA);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MainAC);
                finish();
            }
        });
        };
    }
