package com.li.pc.lutils.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * author   ：mo
 * data     ：2016/12/13
 * time     ：12:00
 * function :通用适配器---fragment与viewpager配合使用
 */

public class CommonFragmentStatePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public CommonFragmentStatePagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> mTitles) {
        super(fm);
        this.mFragments = fragments;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}