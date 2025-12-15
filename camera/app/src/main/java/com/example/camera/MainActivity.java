package com.example.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Bitmap imageBitmap;

    private Button ok, photo;
    private EditText name, adress;
    private Spinner spinner;
    private RadioButton  male, female;
    ActivityResultLauncher<Intent> cameraLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Bundle extras = result.getData().getExtras();
                     imageBitmap = (Bitmap) extras.get("data");
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok = findViewById(R.id.ok);
        photo = findViewById(R.id.photo);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        name = findViewById(R.id.name);
        adress = findViewById(R.id.adress);
        spinner = findViewById(R.id.spinner);

        // Spinner values
        String[] values = {"14", "15", "16", "17"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                values
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        photo.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraLauncher.launch(intent);
        });
        ok.setOnClickListener(v -> {

            // Get values from inputs
            String userName = name.getText().toString();
            String userAddress = adress.getText().toString();
            String userAge = spinner.getSelectedItem().toString();
            String gender = male.isChecked() ? "Male" : "Female";

            // Create intent and send data
            Intent intent = new Intent(MainActivity.this, information.class);
            intent.putExtra("name", userName);
            intent.putExtra("address", userAddress);
            intent.putExtra("age", userAge);
            intent.putExtra("gender", gender);
            if (imageBitmap != null) {
                intent.putExtra("image", imageBitmap);
            }

            startActivity(intent);

        });


    }
}
