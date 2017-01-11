package com.li.pc.lutils.utils;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * author   ：mo
 * data     ：2016/12/22
 * time     ：13:59
 * function : 退出应用
 */

public class UtilsAppExit {
    private List<Activity> activityList=new LinkedList<Activity>();
    private static UtilsAppExit instance;

    private UtilsAppExit(){

    }
    public static UtilsAppExit getInstance(){
        if (instance==null) {
            instance=new UtilsAppExit();
        }
        return instance;
    }
    public void addActivity(Activity activity){
        activityList.add(activity);
    }
    public void exit(){
        for(Activity activity:activityList){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        int id=android.os.Process.myPid();
        if(id!=0){
            android.os.Process
                    .killProcess(id);
        }
    }
}
