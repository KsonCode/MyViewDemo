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
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DotView extends View {
    private Paint redDotPaint;//红色画笔
    private Paint greenDotPaint;//绿色画笔
    private int mRadius = 20;//圆的半径
    private int circleX = 0;//圆心x
    private int circleY = 0;//圆心y
    private int screenWidth,screenHeight;//屏幕宽高
    private List<DotEntity> dotEntityList;//存储小点的集合
    private Rect rect;//矩形框对象
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

        //遍历小点集合
        for (DotEntity dotEntity : dotEntityList) {
            if (!dotEntity.isSelected){//没有被选中
                //绘制小红点
                canvas.drawCircle(dotEntity.circleX,dotEntity.circleY,mRadius,redDotPaint);
            }else{
                //绘制小绿点
                canvas.drawCircle(dotEntity.circleX,dotEntity.circleY,mRadius,greenDotPaint);
            }

        }

        //绘制矩形
        canvas.drawRect(rect,greenDotPaint);


    }

    /**
     * 添加小圆点的方法
     */
    public void add() {

        //随机x坐标
        circleX = new Random().nextInt(screenWidth);
        //随机y坐标
        circleY = new Random().nextInt(screenHeight);

        DotEntity dotEntity = new DotEntity();
        dotEntity.circleX = circleX;
        dotEntity.circleY = circleY;
        //如果小点在矩形范围内
        if (circleX>100&&circleX<500&&circleY>150&&circleY<550){
            //设置小点被选中
            dotEntity.isSelected = true;
        }else{
            //设置小点非选中
            dotEntity.isSelected = false;
        }

        //添加小点集合
        dotEntityList.add(dotEntity);

        invalidate();//重新绘制

    }

    /**
     * 清屏
     */
    public void delete() {
//        if (dotEntityList!=null&&dotEntityList.size()>0){
//
//            dotEntityList.clear();//清空
//
//            invalidate();//重新绘制
//
//        }

        if (dotEntityList!=null&&dotEntityList.size()>0){


            // 获取集合对应的迭代器，用来遍历集合中的元素的。
            Iterator<DotEntity> iterator = dotEntityList.iterator();
            while(iterator.hasNext()){
                boolean isSelected = iterator.next().isSelected;
                if(isSelected){
                    // 注意: 不能用list的remove方法.
                    // list.remove(next);

                    // 使用迭代器中的remove()方法,可以删除元素.
                    iterator.remove();
                }
            }

            invalidate();//重绘方法，调用ondraw方法

            //删除有问题
//            for (DotEntity dotEntity : dotEntityList) {
//
//                if (dotEntity.isSelected){
//                    //迭代器删除
//                    dotEntityList.remove(dotEntity);
//                }
//
//            }
        }

    }
}
