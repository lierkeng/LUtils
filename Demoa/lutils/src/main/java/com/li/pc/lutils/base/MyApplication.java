package com.li.pc.lutils.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import org.xutils.x;
import java.util.LinkedList;
import java.util.List;

/**
 * author   ：mo
 * data     ：2017/1/11
 * time     ：15:29
 * function :定义自己的application 用户初始化一些东西
 */
public class MyApplication extends Application {
    private List<AppCompatActivity> mList = new LinkedList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化xutils
        x.Ext.init(this);
        x.Ext.setDebug(true); // 是否输出debug日志, 开启debug会影响性能.
        //    解决65536
        MultiDex.install(this);
    }

    // 添加 AppCompatActivity
    public void addActivity(AppCompatActivity activity) {
        mList.add(activity);
    }

    //关闭每一个list内的AppCompatActivity
    public void exit() {
        try {
            for (AppCompatActivity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
