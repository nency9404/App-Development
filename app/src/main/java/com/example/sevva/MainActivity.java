package com.example.sevva;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etAddress, etPhone, etEmail, etMessage;
    private Button btnSendMessage;
    private Database dbHandler;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etName = findViewById(R.id.res_name);
        etAddress = findViewById(R.id.editTextText2);
        etPhone = findViewById(R.id.editTextText3);
        etEmail = findViewById(R.id.editTextText4);
        etMessage = findViewById(R.id.editTextText5);
        btnSendMessage = findViewById(R.id.button);






        // Initialize DbHandler
        dbHandler = new Database(this);

        // Set onClickListener for the button
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String address = etAddress.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();
                String message = etMessage.getText().toString();

                if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty() || message.isEmpty()) {
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.insertUserDetails(name, address, phone, email, message);

                Toast.makeText(MainActivity.this, "Message sent successfully", Toast.LENGTH_SHORT).show();

                // Clear fields
                etName.setText("");
                etAddress.setText("");
                etPhone.setText("");
                etEmail.setText("");
                etMessage.setText("");

                // Start next activity
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                intent.putExtra("ADDRESS", address);
                startActivity(intent);
            }
        });
    }
}