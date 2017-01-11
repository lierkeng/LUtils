package com.li.pc.lutils.listener;

import android.support.v4.view.ViewPager;

/**
 * author   ：mo
 * data     ：2016/12/19
 * time     ：11:28
 * function : ViewPager页面变化监听
 */

public class OnPageChangeListener implements ViewPager.OnPageChangeListener {
    /**
     * 当页面在滑动的时候会调用此方法，在滑动被停止之前，此方法回一直得到调用
     * @param position 当前页面，及你点击滑动的页面
     * @param positionOffset 当前页面偏移的百分比
     * @param positionOffsetPixels 当前页面偏移的像素位置
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 页面跳转完后得到调用
     * @param position 当前选中的页面的Position
     */
    @Override
    public void onPageSelected(int position) {

    }

    /**
     * 此方法是在状态改变的时候调用
     * @param state  0==什么都没做 1==正在滑动 2==滑动完了
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
