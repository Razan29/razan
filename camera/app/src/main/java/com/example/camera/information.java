package com.example.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class information extends AppCompatActivity {
    private String name,addres,age,gender;
    private ImageView img ;
    private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_information);
        t=findViewById(R.id.textView);
        img=findViewById(R.id.imageView);
        Intent get = getIntent();
        name= get.getStringExtra("name");
        addres= get.getStringExtra("address");
        age= get.getStringExtra("age");
        gender= get.getStringExtra("gender");
        t.setText(
                "Name: " + name + "\n" +
                        "Address: " + addres + "\n" +
                        "Age: " + age + "\n" +
                        "Gender: " + gender
        );
        Bitmap bit = get.getParcelableExtra("image");
        if (bit != null) {
            img.setImageBitmap(bit);
        } else {
            img.setImageResource(R.drawable.ic_launcher_background);
        }


        };
    }
