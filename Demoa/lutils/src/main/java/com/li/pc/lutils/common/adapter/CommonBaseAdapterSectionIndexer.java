package com.li.pc.lutils.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;

import java.util.ArrayList;
import java.util.List;

/**
 * author   ：mo
 * data     ：2016/12/19
 * time     ：16:45
 * function : 通用BaseAdapter---用于字符索引
 */

public abstract class CommonBaseAdapterSectionIndexer<T> extends BaseAdapter implements SectionIndexer {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;

    /**
     * 构造器
     *
     * @param context
     * @param mDatas
     */
    public CommonBaseAdapterSectionIndexer(Context context, List<T> mDatas) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
    }

    /**
     * 设置数据
     *
     * @param data
     */
    public void setData(List<T> data) {
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
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    public int getPositionForSection(int section) {
//        for (int i = 0; i < getCount(); i++) {
//            String sortStr = list.get(i).getSortLetters();
//            char firstChar = sortStr.toUpperCase().charAt(0);
//            if (firstChar == section) {
//                return i;
//            }
//        }
//
//        return -1;
        return getPositionForSection1(section);
    }
    protected abstract int getPositionForSection1(int section);

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
//        getPositionForSection(getSectionForPosition1(position));
        CommonBaseViewHolder viewHolder = CommonBaseViewHolder.get(mContext, convertView, parent, getLayoutId(position, getItem(position)), position);
        doWhat(viewHolder, getItem(position), position,getSectionForPosition(position),getPositionForSection(getSectionForPosition(position)));
        return viewHolder.getConvertView();
    }

    //    /**
//     *根据位置获取数据的某一部分
//     * 当前位置获取分类的首字母的Char ascii值
//     * @param position
//     * @return
//     */
    public int getSectionForPosition(int position) {
        return getSectionForPosition1(position,mDatas.get(position));
    }

    protected abstract int getSectionForPosition1(int position, T bean);

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
     *  @param holder
     * @param bean
     * @param i
     * @param sectionForPosition
     * @param position
     */
    public abstract void doWhat(CommonBaseViewHolder holder, T bean, int position, int sectionForPosition, int positionForSection);
    @Override
    public Object[] getSections() {
        return null;
    }
}
