package com.laoxu.myviewdemo.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.camera2.params.ColorSpaceTransform;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.Nullable;

import com.laoxu.myviewdemo.view.widget.entity.DotEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DotView extends View {
    private Paint redDotPaint;
    private Paint greenDotPaint;
    private int mRadius = 20;
    private int circleX = 0;
    private int circleY = 0;
    private int screenWidth,screenHeight;
    private List<DotEntity> dotEntityList;
    private Rect rect;
    public DotView(Context context) {
        super(context);
        init();
    }

    public DotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化数据
     */
    public void init(){

        dotEntityList = new ArrayList<>();

        redDotPaint = new Paint();
        redDotPaint.setStyle(Paint.Style.FILL);//实心
        redDotPaint.setColor(Color.RED);

        greenDotPaint = new Paint();
        greenDotPaint.setStyle(Paint.Style.STROKE);//空心
        greenDotPaint.setStrokeWidth(5);
        greenDotPaint.setColor(Color.GREEN);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenHeight = dm.heightPixels;
        screenWidth = dm.widthPixels;
        //left top right bottom,记录坐标
        rect = new Rect(100,150,500,550);





    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (DotEntity dotEntity : dotEntityList) {
            if (!dotEntity.isSelected){//没有被选中
                canvas.drawCircle(dotEntity.circleX,dotEntity.circleY,mRadius,redDotPaint);
            }else{
                canvas.drawCircle(dotEntity.circleX,dotEntity.circleY,mRadius,greenDotPaint);
            }

        }

        canvas.drawRect(rect,greenDotPaint);


    }

    /**
     * 添加小圆点的方法
     */
    public void add() {

        circleX = new Random().nextInt(screenWidth);
        circleY = new Random().nextInt(screenHeight);

        DotEntity dotEntity = new DotEntity();
        dotEntity.circleX = circleX;
        dotEntity.circleY = circleY;
        if (circleX>100&&circleX<500&&circleY>150&&circleY<550){
            dotEntity.isSelected = true;
        }else{
            dotEntity.isSelected = false;
        }

        dotEntityList.add(dotEntity);

        invalidate();//重新绘制

    }

    /**
     * 清屏
     */
    public void delete() {
        if (dotEntityList!=null&&dotEntityList.size()>0){

            dotEntityList.clear();//清空

            invalidate();//重新绘制

        }
    }
}
