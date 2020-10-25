package com.example.home2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumListAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private int mMaxNum;
    final private Context context;

    public NumListAdapter(Context context, int num) {
        this.mMaxNum = num;
        this.context = context;
    }

    public void increaseNum() {
        mMaxNum++;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final int curNum = position + 1;
        final int color = (position % 2 == 1? Color.RED : Color.BLUE);

        holder.mNumberView.setText(String.valueOf(curNum));
        holder.mNumberView.setTextColor(color);
        holder.mNumberView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((MainActivity)context).doOnClick(curNum, color);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMaxNum;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}