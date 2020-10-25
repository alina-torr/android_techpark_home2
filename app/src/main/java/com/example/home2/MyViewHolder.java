package com.example.home2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public final TextView mNumberView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        mNumberView = itemView.findViewById(R.id.number);
    }
}