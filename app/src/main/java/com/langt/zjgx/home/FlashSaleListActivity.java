package com.langt.zjgx.home;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MainFragmentVuPagerAdapter;
import com.langt.zjgx.adapter.MyCommonNavigatorAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.fragment.FlashSaleListFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 限时抢购
 */
public class FlashSaleListActivity extends BaseActivity {
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private String[] mTabs;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_flash_sale_list;
    }

    @Override
    public void initView() {
        mTabs = new String[]{getString(R.string.goods_list_xianshiqianggou_ing), getString(R.string.goods_list_xianshiqianggou_comming_soon)};
        MyCommonNavigatorAdapter myCommonNavigatorAdapter = new MyCommonNavigatorAdapter(mTabs);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(myCommonNavigatorAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);
        mFragments.clear();
        mFragments.add(FlashSaleListFragment.newInstance("order"));
        mFragments.add(FlashSaleListFragment.newInstance("distance"));
        MainFragmentVuPagerAdapter mVuPagerAdapter = new MainFragmentVuPagerAdapter(getSupportFragmentManager(), mFragments);
        viewPager.setAdapter(mVuPagerAdapter);
        ViewPagerHelper.bind(magicIndicator, viewPager);
        myCommonNavigatorAdapter.setOnTabItemClickListener((position, view) -> viewPager.setCurrentItem(position,false));
    }
}
