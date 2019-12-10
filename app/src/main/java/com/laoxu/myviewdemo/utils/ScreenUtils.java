package com.laoxu.myviewdemo.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public class ScreenUtils {

    /**
     * 获取屏幕宽度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();

        return dm.widthPixels;
    }
}
