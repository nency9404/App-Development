package com.example.sevva;

import static com.denzcoskun.imageslider.constants.ScaleTypes.FIT;

import android.content.Intent;
import android.icu.number.Scale;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    Button getstarted_button;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageSlider imageSlider = findViewById(R.id.Imageslider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.slider8, FIT));
        slideModels.add(new SlideModel(R.drawable.slider3, FIT));
        slideModels.add(new SlideModel(R.drawable.slider7, FIT));
        slideModels.add(new SlideModel(R.drawable.slider9, FIT));
        slideModels.add(new SlideModel(R.drawable.slider4, FIT));

        imageSlider.setImageList(slideModels, FIT);

        getstarted_button = (Button) findViewById(R.id.get_started);
        //accept_button = (ImageButton) findViewById(R.id.icon_ngo);

        getstarted_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(login.this, register_login.class);
                startActivity(intent);


            }
        });
    }
}