package com.example.contact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.Holder>{
    private HashMap<String, String> contacts ;
    private ArrayList<String> name,phone;
    public MyRecyclerAdapter(HashMap<String,String> dataSet){
        contacts = dataSet;
        name = new ArrayList<>();
        phone = new ArrayList<>();
        for (String i : contacts.keySet()) {
            name.add(contacts.get(i));
            phone.add(i);
        }
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.setItem(position);
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView textTitle;
        TextView textDescription;
        public Holder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            textDescription = itemView.findViewById(R.id.text_description);
        }
        public void setItem(int position){
            textTitle.setText(name.get(position));
            textDescription.setText(phone.get(position));
        }
    }
}
