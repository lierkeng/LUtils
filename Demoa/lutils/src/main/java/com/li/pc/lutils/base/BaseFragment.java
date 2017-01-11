package com.li.pc.lutils.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;


/**
 * author   ：mo
 * data     ：2017/1/11
 * time     ：15:29
 * function :所有fragment的父类
 */
public class BaseFragment extends Fragment {
    private boolean injected = false;//注入

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        injected = true;
        return x.view().inject(this, inflater, container);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);//判断如果没有注入则进行初始注入
        if (!injected) {
            x.view().inject(this, this.getView());
        }
    }


}
