package com.example.sevva;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    private EditText etName, etAddress, etPhone, etEmail, etMessage;

    Button btnSendMessage;
    String Shared_Pref_Name="mypref";
    String key_name,key_address,key_phone,key_email,key_password;

    Intent i;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize views
        etName = findViewById(R.id.res_name);
        etAddress = findViewById(R.id.editTextText2);
        etPhone = findViewById(R.id.editTextText3);
        etEmail = findViewById(R.id.editTextText4);
        etMessage = findViewById(R.id.editTextText5);
        btnSendMessage = findViewById(R.id.button);


        // Initialize DbHandler
        SharedPreferences sharedPreferences= getSharedPreferences(Shared_Pref_Name,MODE_PRIVATE);

        // Set onClickListener for the button
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Capture input
                String name = etName.getText().toString();
                String address = etAddress.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();
                String password = etMessage.getText().toString();

                // Validation
                if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Registration.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Insert data into database
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.putString("address", address);
                editor.putString("phone", phone);
                editor.putString("email", email);
                editor.putString("password", password);
                editor.apply();

                // Provide feedback
                Toast.makeText(Registration.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                i = new Intent(Registration.this, register_login.class);
                startActivity(i);
                // Clear fields

            }

        });


    }
}