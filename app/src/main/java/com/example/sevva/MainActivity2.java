package com.example.sevva;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity implements OnMapReadyCallback {

    Button da;
    Button sub;
    EditText per,kg,dn;
    TextView loc;
    private GoogleMap mymap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
         da=(Button)findViewById(R.id.btn);
         sub=(Button)findViewById(R.id.btn1);
         per=(EditText) findViewById(R.id.et);
         kg=(EditText) findViewById(R.id.et1);
         dn=(EditText) findViewById(R.id.et2);
         loc=(TextView)findViewById(R.id.tv2);

        Intent intent = getIntent();
        String address = intent.getStringExtra("ADDRESS");
        loc.setText(address);

        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        updateMapWithAddress(address);

        da.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(i);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Thanks for your contribution! We’ll process it shortly",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateMapWithAddress(String address) {
        if (address != null && !address.isEmpty()) {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());

            try {
                List<Address> addressList = geocoder.getFromLocationName(address, 5); // Get 5 results for better chances

                if (addressList != null && !addressList.isEmpty()) {
                    // Get the best result (sometimes first, but logging all to debug)
                    for (Address location : addressList) {
                        Log.d("Geocoding Result", "Found Location: " + location.toString());
                    }

                    // Use the first result as a fallback (adjust based on debugging)
                    Address location = addressList.get(0);
                    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

                    if (mymap != null) {
                        mymap.clear(); // Clear previous markers
                        mymap.addMarker(new MarkerOptions().position(latLng).title("Location: " + address));
                        mymap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                    }
                } else {
                    Log.e("Geocoding Error", "No location found for address: " + address);
                    Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Geocoding Exception", "Error while geocoding: " + e.getMessage());
                Toast.makeText(this, "Error while fetching location", Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e("Address Error", "Empty or null address");
            Toast.makeText(this, "Please provide a valid address", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mymap=googleMap;
        mymap.getUiSettings().setZoomControlsEnabled(true);
        mymap.getUiSettings().setCompassEnabled(true);
    }
}