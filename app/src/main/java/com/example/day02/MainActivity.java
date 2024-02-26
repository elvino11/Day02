package com.example.day02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etHeight = findViewById(R.id.etHeight);
        EditText etWidth = findViewById(R.id.etWidth);
        EditText etLength = findViewById(R.id.etLength);

        TextView tvResult = findViewById(R.id.tvResult);

        Button btnVolume = findViewById(R.id.btnVolume);

        Button btnSurfaceArea = findViewById(R.id.btnSurfaceArea);

        Button btnCircumference = findViewById(R.id.btnCircumference);

        btnVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputHeight = etHeight.getText().toString();
                int height = Integer.parseInt(inputHeight);
                int width = Integer.parseInt(etWidth.getText().toString());
                int length = Integer.parseInt(etLength.getText().toString());

                int volume = length * width * height;

                tvResult.setText(String.valueOf(volume));
            }
        });

        btnSurfaceArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputHeight = etHeight.getText().toString();
                String inputWidth = etWidth.getText().toString();
                String inputLength = etLength.getText().toString();

                if (inputHeight.isEmpty()) {
                    etHeight.setError("Tinggi Tidak Boleh Kosong");
                } else if (inputWidth.isEmpty()) {
                    etWidth.setError("Lebar Tidak Boleh Kosong");
                } else if (inputLength.isEmpty()) {
                    etLength.setError("Panjang Tidak Boleh Kosong");
                }  else  {
                    int height = Integer.parseInt(inputHeight);
                    int width = Integer.parseInt(inputWidth);
                    int length = Integer.parseInt(inputLength);

                    int surfaceArea = 2 * ((length * width ) + (width * height) + (length * height));

                    tvResult.setText(String.valueOf(surfaceArea));
                }
            }
        });

        btnCircumference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputHeight = etHeight.getText().toString();
                String inputWidth = etWidth.getText().toString();
                String inputLength = etLength.getText().toString();

                if (inputHeight.isEmpty()) {
                    etHeight.setError("Tinggi Tidak Boleh Kosong");
                } else if (inputWidth.isEmpty()) {
                    etWidth.setError("Lebar Tidak Boleh Kosong");
                } else if (inputLength.isEmpty()) {
                    etLength.setError("Panjang Tidak Boleh Kosong");
                }  else  {
                    int height = Integer.parseInt(inputHeight);
                    int width = Integer.parseInt(inputWidth);
                    int length = Integer.parseInt(inputLength);

                    int circumference = 4 * (length + width + height);

                    tvResult.setText(String.valueOf(circumference));
                }
            }
        });
    }
}