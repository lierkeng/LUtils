package com.li.pc.lutils.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import org.xutils.common.util.LogUtil;

import java.util.List;


/**
 * author   ：mo
 * data     ：2016/12/16
 * time     ：18:37
 * function : app信息工具类
 */

public class UtilsAppInfo {
    private UtilsAppInfo() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("AppUtil cannot be instantiated");
    }

    /**
     * 取得AppKey
     * @param context
     * @return
     */
    public static String getAppKey(Context context) {
        Bundle metaData = null;
        String appKey = null;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
            if (null != ai)
                metaData = ai.metaData;
            if (null != metaData) {
                appKey = metaData.getString("appKey");
                if ((null == appKey) || appKey.length() != 24) {
                    appKey = null;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {

        }
        return appKey;
    }
    /**
     * 获取应用程序名称
     *
     * @param context
     * @return 当前应用名称
     */
    public static String getAppName(Context context) {
        try {
            //获取程序应用包管理器
            PackageManager packageManager = context.getPackageManager();
            //获取程序应用信息。第一个参数获取包名，相当于上下文，第二个参数为指定获取的信息PackageManager。出来，这是一个int值
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            //获取程序应用名在应用信息里的索引值
            int labelRes = packageInfo.applicationInfo.labelRes;
            //返回这个索引值在res里的对应结果
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取应用程序版本名称信息
     * @param context
     * @return 当前应用的版本名称
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取清单里保存的数据
     * @param context
     * @param str//清单里的key
     * @return 串
     */
    public static String getName(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo packageInfo = packageManager.getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
            return packageInfo.metaData.getString(str);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 判断应用是否已经启动
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isAppAlive(Context context, String packageName) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        List<ActivityManager.RunningAppProcessInfo> processInfos = activityManager
                .getRunningAppProcesses();

        for (int i = 0; i < processInfos.size(); i++) {
            if (processInfos.get(i).processName.equals(packageName)) {
                LogUtil.i("NotificationLaunch"+ String.format("the %s is running, isAppAlive return true", packageName));
                return true;
            }
        }
        LogUtil.i("NotificationLaunch"+ String.format("the %s is not running, isAppAlive return false", packageName));
        return false;

    }

    /**
     * 判断微信客户端是否可用
     * @param context
     * @return
     */
    public static boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 判断qq是否可用
     *
     * @param context
     * @return
     */
    public static boolean isQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }
}
