package com.example.testapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private EditText etName ,etLastName;
    private TextView tvWelcome;
    private RadioButton r1;
    private RadioButton r2;
    private ImageView img;
    private SeekBar sb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.editTextText);
        etLastName=findViewById(R.id.editTextText2);
        tvWelcome=findViewById(R.id.textView2);
        Button btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NewLable="Welcome";
                String name =etName.getText().toString();
                String lastName =etLastName.getText().toString();

                if(!(name.isEmpty())&&!(lastName.isEmpty())){
                    NewLable +=" "+name+" ";
                    NewLable +=lastName;
                    tvWelcome.setText(NewLable);
                    tvWelcome.setTextSize(25);
                }
                else{
                    Toast.makeText(MainActivity.this, "Pleas fill in all fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
        img=findViewById(R.id.imageView);
        r1=findViewById(R.id.radioPink);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(R.drawable.pink);
            }
        });
        r2=findViewById(R.id.radioGold);
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(R.drawable.gold);

    }

});
        sb=findViewById(R.id.seekBar);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvWelcome.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}