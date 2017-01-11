package com.li.pc.lutils.utils;

import android.app.Activity;
import android.view.View;

import org.xutils.common.util.LogUtil;

/**
 * author   ：mo
 * data     ：2016/12/16
 * time     ：16:26
 * function :FindViewById工具类
 */

public class UtilsFindViewById {
    @SuppressWarnings("unchecked")
    public static final <E extends View> E getView(Activity activity, int id) {
        try {
            return (E) activity.findViewById(id);
        } catch (ClassCastException ex) {
            LogUtil.e("Could not cast View to concrete class.", ex);
            throw ex;
        }
    }
}
