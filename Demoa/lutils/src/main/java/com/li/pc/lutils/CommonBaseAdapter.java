package com.li.pc.lutils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author   ：mo
 * data     ：2016/12/19
 * time     ：16:45
 * function : 通用BaseAdapter
 */

public abstract class CommonBaseAdapter<T> extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;

    /**
     * 构造器
     *
     * @param context
     * @param mDatas
     */
    public CommonBaseAdapter(Context context, List<T> mDatas) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
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

    /**
     * 获取数据长度
     *
     * @return
     */
    @Override
    public int getCount() {
//        if (this.mDatas == null) {
//            return 0;
//        }
//        return mDatas.size();
        return mDatas == null ? 0 : mDatas.size();
    }

    /**
     * 获取子项数据
     *
     * @param position
     * @return
     */
    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    /**
     * 获取子项位置
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 获取布局用以处理数据交互
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonBaseViewHolder viewHolder = CommonBaseViewHolder.get(mContext, convertView, parent, getLayoutId(position, getItem(position)), position);
        doWhat(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();
    }

    /**
     * 交互方法--用哪个布局
     *
     * @param position
     * @param bean
     * @return
     */
    protected abstract int getLayoutId(int position, T bean);

    /**
     * 交互方法--要干什么
     *
     * @param holder
     * @param bean
     * @param position
     */
    public abstract void doWhat(CommonBaseViewHolder holder, T bean, int position);

}
