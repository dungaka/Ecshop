package com.langt.zjgx.message.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MainFragmentVuPagerAdapter;
import com.langt.zjgx.adapter.MyCommonNavigatorAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.message.ui.fragment.AppealListFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 消息-申訴頁面
 */
public class AppealMsgListActivity extends BaseActivity {
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private String[] mTabs = new String[]{"待处理", "已处理"};
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_appeal;
    }

    @Override
    public void initView() {
        MyCommonNavigatorAdapter mCommonNavAdapter = new MyCommonNavigatorAdapter(mTabs);

        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(mCommonNavAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);

        mFragments.clear();
        mFragments.add(AppealListFragment.newInstance(Constant.MessageConstant.appeal_type_un_deal));
        mFragments.add(AppealListFragment.newInstance(Constant.MessageConstant.appeal_type_dealed));
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
}
