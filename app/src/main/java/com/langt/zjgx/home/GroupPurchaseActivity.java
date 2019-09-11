package com.langt.zjgx.home;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MainFragmentVuPagerAdapter;
import com.langt.zjgx.adapter.MyCommonNavigatorAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.fragment.GroupPurchaseListFragment;
import com.langt.zjgx.utils.ScreenUtils;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 多人团页面
 */
public class GroupPurchaseActivity extends BaseActivity {
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private MyCommonNavigatorAdapter mCommonNavAdapter;

    private String[] mTabs = {"全部", "酒水饮料", "美食快餐", "休闲零食"};
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_group_purchase;
    }

    @Override
    public void initView() {
        mCommonNavAdapter = new MyCommonNavigatorAdapter(mTabs);

        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(mCommonNavAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);

        mFragments.clear();
        mFragments.add(GroupPurchaseListFragment.newInstance("order"));
        mFragments.add(GroupPurchaseListFragment.newInstance("distance"));
        mFragments.add(GroupPurchaseListFragment.newInstance("star"));
        mFragments.add(GroupPurchaseListFragment.newInstance("rank"));
        MainFragmentVuPagerAdapter mVuPagerAdapter = new MainFragmentVuPagerAdapter(getSupportFragmentManager(), mFragments);
        viewPager.setAdapter(mVuPagerAdapter);

        ViewPagerHelper.bind(magicIndicator, viewPager);
        mCommonNavAdapter.setOnTabItemClickListener(new MyCommonNavigatorAdapter.OnTabItemClickListener() {
            @Override
            public void onTabItemClick(int position, View view) {
                viewPager.setCurrentItem(position, false);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        ScreenUtils.hideSoftInput(this, magicIndicator);
    }
}
