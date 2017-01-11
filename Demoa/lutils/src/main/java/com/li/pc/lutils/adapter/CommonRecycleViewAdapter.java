package com.li.pc.lutils.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * author   ：mo
 * data     ：2016/12/6
 * time     ：18:11
 * function :
 */

public abstract class CommonRecycleViewAdapter<T> extends RecyclerView.Adapter<CommonRecycleViewHolder> {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;


    public CommonRecycleViewAdapter(Context context, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }

    public void addAllData(List<T> dataList) {
        this.mDatas.addAll(dataList);
        this.notifyDataSetChanged();
    }

    @Override
    public CommonRecycleViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        CommonRecycleViewHolder viewHolder = CommonRecycleViewHolder.get(mContext, parent, getLayoutId(viewType, mDatas.get(viewType)));
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    protected abstract int getLayoutId(int position, T bean);

    @Override
    public void onBindViewHolder(CommonRecycleViewHolder holder, int position) {
        doWaht(holder, mDatas.get(position), position);
    }

    public abstract void doWaht(CommonRecycleViewHolder holder, T bean, int position);
    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }
}