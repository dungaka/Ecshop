package com.langt.zjgx.nearby;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MainFragmentVuPagerAdapter;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.Constant;
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

public class NearbyFragment extends BaseFragment {


    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.view_pager)
    ViewPager viewPager;


    private List<Fragment> mFragments = new ArrayList<>();
    private String[] mTabs = {"全部", "酒水饮料", "美食快餐","休闲零食"};
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_nearby;
    }

    public static NearbyFragment newInstance() {

        Bundle args = new Bundle();

        NearbyFragment fragment = new NearbyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initData() {
        super.initData();

        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(mCommonNavAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);
        mFragments.clear();
        mFragments.add(GoodsListFragment.newInstance(Constant.HomeGoodsListOrderType.type_order));
        mFragments.add(GoodsListFragment.newInstance(Constant.HomeGoodsListOrderType.type_distance));
        mFragments.add(GoodsListFragment.newInstance(Constant.HomeGoodsListOrderType.type_star_level));
        mFragments.add(GoodsListFragment.newInstance(Constant.HomeGoodsListOrderType.type_favorable_rate));
        MainFragmentVuPagerAdapter mVuPagerAdapter = new MainFragmentVuPagerAdapter(getChildFragmentManager(), mFragments);
        viewPager.setAdapter(mVuPagerAdapter);
        ViewPagerHelper.bind(magicIndicator, viewPager);


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
            simplePagerTitleView.setNormalColor(ContextCompat.getColor(getActivity(), R.color.black));
            simplePagerTitleView.setSelectedColor(ContextCompat.getColor(getActivity(), R.color.colortheme));
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
            linePagerIndicator.setLineHeight(DisplayUtil.dip2px(getActivity(),2));
            linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
            linePagerIndicator.setColors(ContextCompat.getColor(getActivity(), R.color.colortheme));
            return linePagerIndicator;
        }
    };
}
