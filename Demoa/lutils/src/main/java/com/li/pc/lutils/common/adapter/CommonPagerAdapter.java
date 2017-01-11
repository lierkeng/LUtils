package com.li.pc.lutils.common.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * author   ：mo
 * data     ：2016/12/20
 * time     ：17:38
 * function :通用PagerAdapter
 */

public abstract class CommonPagerAdapter<T> extends PagerAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;

    public CommonPagerAdapter(Context mContext, List<T> mDatas) {
        this.mContext = mContext;
        this.mInflater  = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    /**
     * 设置数据
     *
     * @param data
     */
    public void setData(ArrayList<T> data) {
        this.mDatas = data;
        this.notifyDataSetChanged();
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void addData(ArrayList<T> data) {
        if (data != null) {
            this.mDatas.addAll(data);
        }
        this.notifyDataSetChanged();
    }

    /**
     * 删除数据
     *
     * @param t
     */
    public void delData(T t) {
        if (mDatas != null || mDatas.size() != 0) {
            this.mDatas.remove(t);
        }
        this.notifyDataSetChanged();
    }

    /**
     * 获取数据
     *
     * @return
     */
    public ArrayList<T> getAllData() {
        return (ArrayList<T>) this.mDatas;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mInflater.inflate(getLayoytId(position,mDatas.get(position)), null);
        container.addView(view);
        doWhat(view,getItem(position), position);
        return view;
    }

    protected abstract int getLayoytId(int position, T bean) ;
    protected abstract void doWhat(View view, T bean, int position);


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

    public T getItem(int position) {
        return mDatas.get(position);
    }
}
