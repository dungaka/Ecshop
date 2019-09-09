package com.langt.zjgx.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类内的每一个生成的 Fragment 都将保存在内存之中，
 * 因此适用于那些相对静态的页，数量也比较少的那种；
 * 如果需要处理有很多页，并且数据动态性较大、占用内存较多的情况，
 * 应该使用FragmentStatePagerAdapter。
 */
public class BaseFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    private FragmentManager fragmentManager;

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentManager = fm;
        this.fragmentList = fragmentList;
    }

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> mTitles) {
        super(fm);
        this.mTitles = mTitles;
        this.fragmentManager = fm;
        setFragments(fragmentList, mTitles);
    }

    //刷新fragment
    public void setFragments(List<Fragment> fragments, List<String> mTitles) {
        this.mTitles = mTitles;
        if (fragmentList != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            for (Fragment f : fragmentList) {
                ft.remove(f);
            }
            ft.commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        fragmentList = fragments;
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (null == mTitles || mTitles.isEmpty()) ? "" : mTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        fragmentManager.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        fragmentManager.beginTransaction().hide(getItem(position)).commit();
    }
}
