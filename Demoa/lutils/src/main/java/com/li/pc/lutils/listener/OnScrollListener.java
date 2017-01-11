package com.li.pc.lutils.listener;

import android.support.v4.widget.NestedScrollView;
import android.widget.AbsListView;
import android.widget.NumberPicker;

/**
 * author   ：mo
 * data     ：2016/12/19
 * time     ：11:31
 * function : 滚动监听 实现父类AbsListView的滑动监听、数值选择器的滑动监听、NestedScrollView的滑动监听
 */

public class OnScrollListener implements AbsListView.OnScrollListener, NumberPicker.OnScrollListener,NestedScrollView.OnScrollChangeListener {
    /**
     * scrollState有三种状态，分别是SCROLL_STATE_IDLE、SCROLL_STATE_TOUCH_SCROLL、SCROLL_STATE_FLING
     * SCROLL_STATE_IDLE是当屏幕停止滚动时
     * SCROLL_STATE_TOUCH_SCROLL是当用户在以触屏方式滚动屏幕并且手指仍然还在屏幕上时（The user is scrolling using touch, and their finger is still on the screen）
     * SCROLL_STATE_FLING是当用户由于之前划动屏幕并抬起手指，屏幕产生惯性滑动时（The user had previously been scrolling using touch and had performed a fling）
     */
    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {

    }

    /**
     * firstVisibleItem 表示在当前屏幕显示的第一个listItem在整个listView里面的位置（下标从0开始）
     * visibleItemCount表示在现时屏幕可以见到的ListItem(部分显示的ListItem也算)总数
     * totalItemCount表示ListView的ListItem总数
     * listView.getLastVisiblePosition()表示在现时屏幕最后一个ListItem
     * (最后ListItem要完全显示出来才算)在整个ListView的位置（下标从0开始）
     */
    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    /**
     * 这个是数值选择器的滑动监听，
     *
     * @param numberPicker
     * @param scrollState；OnScrollListener滑动事件，滑动事件有三个状态: SCROLL_STATE_FLING:手离开之后还在滑动
     *                                          SCROLL_STATE_IDLE：不滑动
     *                                          SCROLL_STATE_TOUCH_SCROLL:滑动中
     *                                          public void onScrollStateChange(NumberPicker view, int scrollState) {
     *                                          switch (scrollState) {
     *                                          case OnScrollListener.SCROLL_STATE_FLING:
     *                                          Toast.makeText(this, "后续滑动(飞呀飞，根本停下来)", Toast.LENGTH_LONG)
     *                                          .show();
     *                                          break;
     *                                          case OnScrollListener.SCROLL_STATE_IDLE:
     *                                          Toast.makeText(this, "不滑动", Toast.LENGTH_LONG).show();
     *                                          break;
     *                                          case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
     *                                          Toast.makeText(this, "滑动中", Toast.LENGTH_LONG)
     *                                          .show();
     *                                          break;
     *                                          }
     *                                          }
     */
    @Override
    public void onScrollStateChange(NumberPicker numberPicker, int scrollState) {

    }

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

    }
}