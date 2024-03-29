package com.laoxu.myviewdemo.view.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.laoxu.myviewdemo.R;

/**
 * 搜索控件：组合方式
 */
public class SearchLayout extends LinearLayout {
    private FlowLayout flowLayout;
    private ImageView clearIv;
    private TextView tv_search;
    private EditText editText;
    public SearchLayout(Context context) {
        this(context,null);
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化方法
     */
    public void init(Context context){
        //渲染布局
        View view = View.inflate(context, R.layout.search_layout,null);
        //把当前布局添加到当前组合控件之上
        addView(view);
        flowLayout = findViewById(R.id.layout_flow);
        clearIv  = findViewById(R.id.clear);
        tv_search = findViewById(R.id.tv_search);
        editText = findViewById(R.id.et);

        /**
         * 清空数据
         */
        clearIv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                flowLayout.clearViews();

            }
        });

        tv_search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString())){
                    Toast.makeText(getContext(), "关键词不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                //添加流式布局的view和数据
                addFlowLayout(editText.getText().toString());
            }
        });
    }

    /**
     * 添加流式布局的对象
     * @param s
     */
    public void addFlowLayout(String s){
        flowLayout.addChildView(s);
    }


}
