package com.example.home2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements NumberClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.activity_main, new ListFragment())
                    .commit();
        }
    }

    @Override
    public void doOnClick(int curNum, int color) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main, NumFragment.newInstance(curNum, color))
                .addToBackStack(null)
                .commit();
    }
}