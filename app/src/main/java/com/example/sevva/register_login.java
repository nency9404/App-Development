package com.example.sevva;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class register_login extends AppCompatActivity {

    Intent intent;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register_login);

       button = findViewById(R.id.btn);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               intent = new Intent(register_login.this, MainActivity.class);
               startActivity(intent);
           }
       });

    }
}