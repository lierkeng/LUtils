package com.li.pc.lutils.listener;

import android.content.DialogInterface;
import android.view.View;

/**
 * Created by pc on 2016/8/12.
 * 点击监听；实现三种父类监听---》普通点击、长按点击、对话框点击
 */
public class OnClickListener implements View.OnClickListener,View.OnLongClickListener ,DialogInterface.OnClickListener{
    /**
     * 正常的点击
     * @param view
     */
    @Override
    public void onClick(View view) {

    }

    /**
     * 长按点击
     * @param view
     * @return
     */
    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    /**
     *对话框点击
     * @param dialogInterface
     * @param i；对话框选项的值
     */
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }
}
