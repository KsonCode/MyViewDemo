package com.laoxu.myviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.laoxu.myviewdemo.view.widget.RoundedView;

public class RoundedActivity extends AppCompatActivity {

    private RoundedView roundedView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounded);
        roundedView = findViewById(R.id.rview);

//        roundedView.setColor(Color.BLUE);
    }


}
