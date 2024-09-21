package com.example.sevva;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Reader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> datasource;
    LinearLayoutManager linearLayoutManager;
    MyRvAdapter myRvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.horizontal_img);

    }
    class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder>
    {
        ArrayList<String> data;
        public MyRvAdapter(ArrayList<String> data){
            this.data = data;
        }
        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        }

        class MyHolder extends RecyclerView.ViewHolder
        {
            public MyHolder(@NonNull View itemView)
            {
                super(itemView);
            }
        }
    }
}