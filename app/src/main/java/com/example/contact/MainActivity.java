package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private HashMap<String, String> contacts = new HashMap<String, String>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void clk(View view){
        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);


        if(name.getText().toString().trim().length() != 0 && phone.getText().toString().trim().length() != 0){

            contacts.put(phone.getText().toString(),name.getText().toString());
            adapter = new MyRecyclerAdapter(contacts);
            recyclerView.setAdapter(adapter);
            name.getText().clear();
            phone.getText().clear();
        }
    }
}