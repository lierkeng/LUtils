package com.li.pc.lutils.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

/**
 * author   ：mo
 * data     ：2016/12/21
 * time     ：10:31
 * function :
 */

public class UtilsSystem {
    private UtilsSystem() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    /**
     * 改变标题颜色
     *
     * @param act
     * @param colorId
     */
    public static void setSystemBar(Activity act, int colorId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = act.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(act.getResources().getColor(colorId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
