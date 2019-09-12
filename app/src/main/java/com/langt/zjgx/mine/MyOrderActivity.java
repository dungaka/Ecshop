package com.langt.zjgx.mine;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MainFragmentVuPagerAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.ui.GoodsListFragment;
import com.langt.zjgx.utils.DisplayUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyOrderActivity extends BaseActivity {


    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private List<Fragment> mFragments = new ArrayList<>();
    private String[] mTabs = {"全部", "待付款", "拼团中","待取/收货","待评价","退款售后"};
    private int index;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_myorder;
    }

    @Override
    public void initView() {

        index = getIntent().getIntExtra("index",0);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(mCommonNavAdapter);
        commonNavigator.setAdjustMode(false);
        magicIndicator.setNavigator(commonNavigator);
        mFragments.clear();
        mFragments.add(OrderListFragment.newInstance("all"));
        mFragments.add(OrderListFragment.newInstance("distance"));
        mFragments.add(OrderListFragment.newInstance("star"));
        mFragments.add(OrderListFragment.newInstance("rank"));
        mFragments.add(OrderListFragment.newInstance("rank"));
        mFragments.add(OrderListFragment.newInstance("rank"));
        MainFragmentVuPagerAdapter mVuPagerAdapter = new MainFragmentVuPagerAdapter(getSupportFragmentManager(), mFragments);
        viewPager.setAdapter(mVuPagerAdapter);
        ViewPagerHelper.bind(magicIndicator, viewPager);
        viewPager.setCurrentItem(index);


    }

    public CommonNavigatorAdapter mCommonNavAdapter = new CommonNavigatorAdapter() {

        @Override
        public int getCount() {
            return mTabs.length;
        }

        @Override
        public IPagerTitleView getTitleView(Context context, final int index) {
            SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
            simplePagerTitleView.setText(mTabs[index]);
            simplePagerTitleView.setNormalColor(ContextCompat.getColor(MyOrderActivity.this, R.color.black));
            simplePagerTitleView.setSelectedColor(ContextCompat.getColor(MyOrderActivity.this, R.color.colortheme));
            simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(index, false);
                }
            });

            return simplePagerTitleView;
        }


        @Override
        public IPagerIndicator getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setLineHeight(DisplayUtil.dip2px(MyOrderActivity.this,2));
            linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
            linePagerIndicator.setColors(ContextCompat.getColor(MyOrderActivity.this, R.color.colortheme));
            return linePagerIndicator;
        }
    };
}
