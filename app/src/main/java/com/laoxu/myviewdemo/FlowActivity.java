package com.laoxu.myviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.laoxu.myviewdemo.view.widget.FlowLayout;

public class FlowActivity extends AppCompatActivity {
    private FlowLayout flowLayout;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        flowLayout = findViewById(R.id.layout_flow);
        et = findViewById(R.id.et);
    }

    /**
     * 点击搜索，动态添加流式布局的textview
     * @param view
     */
    public void search(View view) {

        flowLayout.addChildView(et.getText().toString());
    }
}
