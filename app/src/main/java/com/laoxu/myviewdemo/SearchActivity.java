package com.laoxu.myviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.laoxu.myviewdemo.view.widget.SearchLayout;

public class SearchActivity extends AppCompatActivity {

    private SearchLayout searchLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchLayout = findViewById(R.id.layout_search);



//        searchLayout.addFlowLayout("inininniin");


    }
}
