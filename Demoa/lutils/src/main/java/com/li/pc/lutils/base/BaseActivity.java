package com.li.pc.lutils.base;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.xutils.common.util.LogUtil;
import org.xutils.x;

/**
 * author   ：mo
 * data     ：2017/1/11
 * time     ：15:29
 * function :所有Activity的父类
 */
public abstract class BaseActivity extends AppCompatActivity {
    /** Notification管理 */
    public NotificationManager mNotificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
    public final <E extends View> E getView(int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            LogUtil.e("==========================="+"不能将视图投射到具体的类.", ex);
            throw ex;
        }
    }
    /**
     * 吐司
     *
     * @param text
     */
    public void ShowToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
