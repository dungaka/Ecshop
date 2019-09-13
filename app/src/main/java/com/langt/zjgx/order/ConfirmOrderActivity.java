package com.langt.zjgx.order;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MainFragmentVuPagerAdapter;
import com.langt.zjgx.adapter.MyCommonNavigatorAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.order.fragment.ConfirmOrderChoosePeiSongFragment;
import com.langt.zjgx.order.fragment.ConfirmOrderGoShopToGetFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 确认订单页面
 */
public class ConfirmOrderActivity extends BaseActivity {
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private List<Fragment> mFragments = new ArrayList<>();
    private String[] mTabs;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_confirm_order;
    }

    @Override
    public void initView() {
        mTabs = new String[]{getString(R.string.confirm_order_get_goods_by_self), getString(R.string.confirm_order_get_goods_by_peisong)};
        CommonNavigator commonNavigator = new CommonNavigator(this);
        MyCommonNavigatorAdapter mCommonNavAdapter = new MyCommonNavigatorAdapter(mTabs);
        commonNavigator.setAdapter(mCommonNavAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);
        mFragments.clear();
        mFragments.add(ConfirmOrderGoShopToGetFragment.newInstance());
        mFragments.add(ConfirmOrderChoosePeiSongFragment.newInstance());
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

    @OnClick({R.id.tv_submit_order})
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.tv_submit_order:

                break;
        }
    }
}
