package com.li.pc.lutils.utils;

import android.content.Context;
import android.widget.Toast;

import org.xutils.x;

/**
 * author   ：mo
 * data     ：2016/11/11
 * time     ：13:59
 * function :Toast工具类
 */
public class UtilsToast {
    /* 是否显示Toast */
    public static boolean isShow = true;

    private UtilsToast() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("ToastUtil cannot be instantiated");
    }
    public static void showShort() {
        if (isShow)
            Toast.makeText(x.app(), "网络不给力", Toast.LENGTH_SHORT).show();
    }
    /**
     * 短时间显示Toast
     *
     * @param message
     */
    public static void showShort( String message) {
        if (isShow)
            Toast.makeText(x.app(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow)
            Toast.makeText(context, message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, int message, int duration) {
        if (isShow)
            Toast.makeText(context, message, duration).show();
    }
}
