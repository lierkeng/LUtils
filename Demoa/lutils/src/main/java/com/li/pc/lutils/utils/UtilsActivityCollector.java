package com.li.pc.lutils.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * author   ：mo
 * data     ：2017/1/11
 * time     ：16:54
 * function :界面控制器
 * 用来退出程序
 */

public class UtilsActivityCollector {
    private static volatile UtilsActivityCollector instance;
    public static List<Activity> activities = new ArrayList<Activity>();

    public UtilsActivityCollector() {
    }

    /**
     * 单例
     *
     * @return
     */
    public static UtilsActivityCollector getInstance() {
        if (instance == null) {
            synchronized (UtilsActivityCollector.class) {
                if (instance == null) {
                    instance = new UtilsActivityCollector();
                }
            }
        }
        return instance;
    }

    /**
     * 添加activity
     *
     * @param activity
     */

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 删除activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 删除所有activity
     */
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
