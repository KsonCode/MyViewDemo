package com.laoxu.myviewdemo.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CircleView extends View {

    private Paint paint;//画笔

    private Paint bluePaint;//蓝色画笔
    private int circleX = 700;//动态圆心，x轴
    private int circleY = 700;//动态圆心，y轴

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**&
     *初始化数据，初始化对象
     */
    public void init(){
        paint = new Paint();
        paint.setColor(Color.RED);//画笔颜色
        paint.setAntiAlias(true);//抗锯齿
        paint.setStrokeWidth(10);//画笔的粗细：10个px，10个像素
//        paint.setStyle(Paint.Style.FILL);//填充
        paint.setStyle(Paint.Style.STROKE);//空心

        bluePaint = new Paint();
        bluePaint.setColor(Color.BLUE);//画笔颜色
        bluePaint.setAntiAlias(true);//抗锯齿
        bluePaint.setStrokeWidth(10);//画笔的粗细：10个px，10个像素
        paint.setStyle(Paint.Style.FILL);//填充
    }


    /**
     * 绘制图形
     * @param canvas 这是画布对象，canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //cx:x轴坐标，cy，y轴坐标，是一个圆心的坐标，radius：半径，paint画笔
        canvas.drawCircle(100,100,100,paint);

        canvas.drawCircle(circleX,circleY,400,bluePaint);

        //矩形对象
        Rect rect = new Rect(250,250,700,500);
        canvas.drawRect(rect,paint);
    }

    /**
     * 触摸事件的监听
     * @param event
     * @return
     */
    int x = 0;//按下的x轴坐标
    int y = 0;//按下的y坐标
    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()){
           case  MotionEvent.ACTION_DOWN:
               x = (int) event.getX();//获取x轴坐标
               y = (int) event.getY();//获取y轴点击坐标


            break;
            case  MotionEvent.ACTION_MOVE:

                //动态设置圆心的点击位置
                circleX = (int) event.getX();
                circleY = (int) event.getY();

                System.out.println("circlex==="+circleX);
                System.out.println("circley==="+circleY);
                //重绘制
                invalidate();//重新运行ondraw方法

            break;
            case  MotionEvent.ACTION_UP:
                x = (int) event.getX();
                y = (int) event.getY();
                if (x>0&&x<200&&y>0&&y<200){
                    Toast.makeText(getContext(),"圆形",Toast.LENGTH_SHORT).show();
                }
                if (x>250&&x<700&&y>250&&y<500){
                    Toast.makeText(getContext(),"矩形",Toast.LENGTH_SHORT).show();
                }

            break;
        }

        return true;



    }
}
