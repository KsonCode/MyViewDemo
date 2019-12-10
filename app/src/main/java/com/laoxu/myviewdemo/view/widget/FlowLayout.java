package com.laoxu.myviewdemo.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laoxu.myviewdemo.R;
import com.laoxu.myviewdemo.utils.ScreenUtils;

public class FlowLayout extends ViewGroup {

    private int horizontalSize = 30;//水平的间距
    private int verticalSize = 30;//垂直的间距

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    /**
     * 布局
     * @param changed 改变，就是布局发生改变的时候 changed=true
     * @param l left
     * @param t top
     * @param r  right
     * @param b  bottom
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int left =0 ;
        int top = 0;
        int right = 0;
        int bottom = 0;

        int childCount = getChildCount();//获取当前容器的子控件数量
        System.out.println("count===="+childCount);
        //遍历子view
        if (childCount>0){
            for (int i = 0; i < childCount; i++) {
                //获取每个子控件对象
                View childView = getChildAt(i);

                //测量子view,自动测量宽和高
                childView.measure(0,0);
                //可以得到每一个子view的宽和高

                int childWidth = childView.getMeasuredWidth();//测量过的宽度
                int childHeight = childView.getMeasuredHeight();//测量过的高度

                //折行判断

               int screenWidth =  ScreenUtils.getScreenWidth(getContext());

               //计算right，所有的right的宽度
                right = left+childWidth;
                if (right>screenWidth){//折行，另起一行
                    left = 0;
                    right = left+childWidth;
                    top = bottom+verticalSize;
                }
                //不换行
                bottom = top+childHeight;

                childView.layout(left,top,right,bottom);

                left += childWidth+horizontalSize;

            }


        }





    }


    /**
     * 动态添加子view
     * @param s
     */
    public void addChildView(String s) {

        TextView textView = new TextView(getContext());

        textView.setPadding(20, 0, 20, 0);
        textView.setText(s);
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
        textView.setTextSize(12);


        //加到容器
        addView(textView);
    }
}
