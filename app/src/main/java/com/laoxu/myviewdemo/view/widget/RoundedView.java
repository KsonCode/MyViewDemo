package com.laoxu.myviewdemo.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.laoxu.myviewdemo.R;

public class RoundedView extends View {
    private Paint mPaint;//画圆角矩形
    private int size;//矩形宽度
    public RoundedView(Context context) {
        this(context,null);

    }

    public RoundedView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);

    }

    public RoundedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    /**
     * 初始化画笔等数据（对象）
     */
    public void init(Context context, AttributeSet attrs){
        mPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        //第一步得到attrs.xml文件声明的自定义属性对象,roundView
//属性列表
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundedView);

        //获取属性列表对象的颜色属性
        int color = typedArray.getColor(R.styleable.RoundedView_roundColor,Color.BLACK);

        //获取属性列表的大小属性
        size = typedArray.getDimensionPixelSize(R.styleable.RoundedView_roundWidthSize,600);

        //在业务逻辑层面，哪里使用到这个属性，就在哪里配置
        mPaint.setColor(color);

    }

    /**
     * 绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF = new RectF(100,100,size,400);

        canvas.drawRoundRect(rectF,20,20,mPaint);


    }

    /**
     * 设置颜色
     * @param color
     */
    public void setColor(int color) {

        mPaint.setColor(color);
        invalidate();
    }
}
