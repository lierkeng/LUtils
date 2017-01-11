package com.li.pc.lutils.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by pc on 2016/9/1.
 * 跳界面工具类
 */

public class UtilsNextActivity {
    public UtilsNextActivity() {
    }

    /**
     * 跳界面
     *
     * @param fromAct 起始
     * @param toAct 终点
     */
    public static void toNextActivity(Context fromAct, Class<?> toAct) {
        Intent intent = new Intent(fromAct, toAct);
        fromAct.startActivity(intent);
    }

    /**
     * 带数据跳界面  数据格式为字符串
     *
     * @param fromAct 起始
     * @param toAct   终点
     * @param str     数据
     *                获取数据
     *                getIntent().getStringExtra("extra")
     */
    public static void toNextActivity(Context fromAct, Class<?> toAct, String str) {
        Intent intent = new Intent(fromAct, toAct);
        intent.putExtra("extra", str);
        fromAct.startActivity(intent);
    }

    /**
     * 带数据跳界面 数据格式为object
     *
     * @param fromAct 起始
     * @param toAct   终点
     * @param obj     数据
     *                获取数据
     *                getIntent().getStringExtra("extra")
     */
    public static void toNextActivity(Context fromAct, Class<?> toAct, Object obj) {
        Intent intent = new Intent(fromAct, toAct);
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra", (Serializable) obj);
        intent.putExtras(bundle);
        fromAct.startActivity(intent);
    }

    /**
     * 带数据跳界面 数据格式为Bundle
     * @param fromAct
     * @param toAct
     * @param bundle
     */
    public static void toNextActivity(Context fromAct, Class<?> toAct, Bundle bundle) {
        Intent intent = new Intent(fromAct, toAct);
        intent.putExtras(bundle);
        fromAct.startActivity(intent);
    }

    /**
     * 带数据跳界面 到两一个界面的startActivityForResult方法
     * @param activity
     * @param intent
     * @param requestCode
     */
    public static void toNextActivityForResult(Activity activity, Intent intent, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
    }
}
