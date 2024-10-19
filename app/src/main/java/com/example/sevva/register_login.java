package com.example.sevva;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register_login extends AppCompatActivity {

    Intent i,intent;
    Button button;
    TextView register;
    EditText username;
    EditText password;
    String Shared_Pref_Name="mypref";
    String key_value="username_1";
    String key_pass="password_1";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register_login);

       button = findViewById(R.id.btn);
       username = findViewById(R.id.edit_user);
       password = findViewById(R.id.edit_pass);
       register= findViewById(R.id.register_here);

        SharedPreferences sharedPreferences= getSharedPreferences(Shared_Pref_Name,MODE_PRIVATE);


       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String storedusername = sharedPreferences.getString("email","");
               String storedpassword = sharedPreferences.getString("password","");
               String a = username.getText().toString();
               String b = password.getText().toString();


               if(a.equals(storedusername) && b.equals(storedpassword)) {
                   intent = new Intent(register_login.this, MainActivity1.class);
                   startActivity(intent);
               }
               else
               {
                   Toast.makeText(register_login.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
               }
           }


       });
       register.setOnClickListener(view -> {
           i = new Intent(register_login.this, Registration.class);
           startActivity(i);
       });

    }
}