package com.example.home2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragment extends Fragment {

    private int mNum;
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mNum = savedInstanceState.getInt("maxNum");
        } else {
            mNum = getResources().getInteger(R.integer.default_max_number);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View list = inflater.inflate(R.layout.list_fragment, container, false);

        RecyclerView recyclerView = list.findViewById(R.id.recycler);

        int columnNumber = getResources().getInteger(R.integer.column_number);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columnNumber));
        final NumListAdapter adapter = new NumListAdapter(mContext, mNum);
        recyclerView.setAdapter(adapter);

        Button addNumberButton = list.findViewById(R.id.addNumberButton);
        addNumberButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                increaseNum(adapter);
                adapter.notifyItemInserted(mNum);
            }
        });

        return list;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof NumberClickListener) {
            this.mContext = context;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("maxNum", mNum);
    }

    public void increaseNum(NumListAdapter adapter) {
        mNum++;
        adapter.increaseNum();
    }
}
