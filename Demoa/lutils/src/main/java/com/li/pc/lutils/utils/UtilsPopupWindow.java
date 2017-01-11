package com.li.pc.lutils.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.li.pc.lutils.R;

/**
 * author   ：mo
 * data     ：2017/1/11
 * time     ：16:41
 * function :
 */

public class UtilsPopupWindow {
    /**
     * 获取pop布局View
     *
     * @param context
     * @param layoutId
     * @return
     */
    public static View getView(Context context, int layoutId) {
        View v = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(layoutId, null);
        return v;
    }

    /**
     * 初始化pop窗口，默认一些设置
     *
     * @param context
     * @param v
     * @param atLocationId
     * @return
     */
    public static PopupWindow initPop(Activity context, View v, int atLocationId) {
        PopupWindow window = new PopupWindow(v, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setFocusable(true); // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setBackgroundDrawable(new ColorDrawable(0xb000000)); // 实例化一个ColorDrawable颜色为半透明
        window.setAnimationStyle(R.style.mypopwindow_anim_style); // 设置popWindow的显示和消失动画
        window.showAtLocation(context.findViewById(atLocationId), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 在底部显示
        return window;
    }
}
