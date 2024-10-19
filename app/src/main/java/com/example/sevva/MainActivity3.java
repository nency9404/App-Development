package com.example.sevva;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private SearchView searchView;
    private TextView allTab, mostRecentTab;
    private CardView card1, card2, card3, card4, card5, card6;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);  // Inflate the layout

        // Initialize views from layout
        searchView = findViewById(R.id.search);
        allTab = findViewById(R.id.featuredItemsTab);
        mostRecentTab = findViewById(R.id.mostRecentTab);

        // CardViews
        card1 = findViewById(R.id.card_1);
        card2 = findViewById(R.id.card_2);
        card3 = findViewById(R.id.card_3);
        card4 = findViewById(R.id.card_4);
        card5 = findViewById(R.id.card_5);
        card6 = findViewById(R.id.card_6);

        // Set up SearchView listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search query submission
                Toast.makeText(MainActivity3.this, "Searching for: " + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle text change (for example, filter the list)
                Toast.makeText(MainActivity3.this, "Text changed to: " + newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Set up Tab click listeners
        allTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "All NGOs", Toast.LENGTH_SHORT).show();

                // Add logic to show all NGOs (or apply filtering logic)
            }
        });

        mostRecentTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Most Recent NGOs", Toast.LENGTH_SHORT).show();
                // Add logic to filter NGOs by "Most Recent"
            }
        });

        // Set up CardView click listeners
        setupCardViewListeners();
    }

    private void setupCardViewListeners() {
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Clicked on Feeding India", Toast.LENGTH_SHORT).show();
                i=new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
                // Navigate to NGO details or perform any other action
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Clicked on Mera Parivar", Toast.LENGTH_SHORT).show();
                i=new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
                // Navigate to NGO details or perform any other action
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Clicked on Roti", Toast.LENGTH_SHORT).show();
                i=new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
                // Navigate to NGO details or perform any other action
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Clicked on Prayas", Toast.LENGTH_SHORT).show();
                i=new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
                // Navigate to NGO details or perform any other action
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Clicked on Roti ", Toast.LENGTH_SHORT).show();
                i=new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
                // Navigate to NGO details or perform any other action
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Clicked on Mera Parivar ", Toast.LENGTH_SHORT).show();
                // Navigate to NGO details or perform any other action
                i=new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }

}