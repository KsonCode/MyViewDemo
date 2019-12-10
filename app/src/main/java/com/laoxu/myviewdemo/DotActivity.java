package com.laoxu.myviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.laoxu.myviewdemo.view.widget.DotView;

public class DotActivity extends AppCompatActivity {

    private DotView dotView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot);

        getSupportActionBar().hide();

        dotView = findViewById(R.id.dotView);
    }

    /**
     * delete
     * @param view
     */
    public void delete(View view) {

        dotView.delete();

    }

    /**
     * add
     * @param view
     */
    public void add(View view) {

        dotView.add();


    }
}
