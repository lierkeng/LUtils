package com.li.pc.lutils.listener;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * author   ：mo
 * data     ：2016/12/19
 * time     ：11:33
 * function : 文本变化监听
 * 使用；tv.addTextChangedListener(new TextWatcher()
 */

public class TextChangedListener implements TextWatcher {
    /**
     * 文本变化前
     *
     * @param s
     * @param start
     * @param count
     * @param after
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    /**
     * 正在变化
     *
     * @param s
     * @param start
     * @param before
     * @param count
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    /**
     * 变化后
     *
     * @param s
     */
    @Override
    public void afterTextChanged(Editable s) {

    }
}