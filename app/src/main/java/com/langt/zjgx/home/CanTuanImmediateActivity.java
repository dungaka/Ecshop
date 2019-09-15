package com.langt.zjgx.home;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MainFragmentVuPagerAdapter;
import com.langt.zjgx.adapter.MyCommonNavigatorAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.fragment.CanTuanGoodsListFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 立即参团
 */
public class CanTuanImmediateActivity extends BaseActivity {
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private String[] mTabs = {"全部","生鲜果蔬"};
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cantuan_immediate;
    }

    @Override
    public void initView() {
        MyCommonNavigatorAdapter myCommonNavigatorAdapter = new MyCommonNavigatorAdapter(mTabs);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(myCommonNavigatorAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);
        mFragments.clear();
        mFragments.add(CanTuanGoodsListFragment.newInstance("order"));
        mFragments.add(CanTuanGoodsListFragment.newInstance("distance"));
        MainFragmentVuPagerAdapter mVuPagerAdapter = new MainFragmentVuPagerAdapter(getSupportFragmentManager(), mFragments);
        viewPager.setAdapter(mVuPagerAdapter);
        ViewPagerHelper.bind(magicIndicator, viewPager);
        myCommonNavigatorAdapter.setOnTabItemClickListener((position, view) -> viewPager.setCurrentItem(position,false));
    }
}
