package com.langt.zjgx.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.GoodsAdapter;
import com.langt.zjgx.adapter.HomeAdapter;
import com.langt.zjgx.adapter.MainFragmentVuPagerAdapter;
import com.langt.zjgx.adapter.RecycleViewDivider;
import com.langt.zjgx.adapter.ShopAdapter;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.model.Banner;
import com.langt.zjgx.home.model.GoodsBean;
import com.langt.zjgx.ui.GoodsListFragment;
import com.langt.zjgx.utils.DisplayUtil;
import com.langt.zjgx.widget.banner.BannerAdapter;
import com.langt.zjgx.widget.banner.BannerLayout;

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

public class HomeFragment extends BaseFragment {


    @BindView(R.id.layout_banner)
    BannerLayout bannerLayout;
    @BindView(R.id.rcy_shop)
    RecyclerView rcyShop;
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private BannerAdapter<Banner> mBannerAdapter;

    protected List<GoodsBean> list = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();
    private MainFragmentVuPagerAdapter mVuPagerAdapter;
    private String[] mTabs = {"下单量", "距离", "店铺星级","好评率"};

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_home;
    }

    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mBannerAdapter = new BannerAdapter<Banner>() {
            @Override
            protected void bind(BannerAdapter.ViewHolder holder, Banner data) {
//                GlideUtils.loadBanner(data.getPicture(), holder.ivBannerItem);
            }
        };
        bannerLayout.setBannerAdapter(mBannerAdapter);


        rcyShop.setLayoutManager(new LinearLayoutManager(getContext()));

        rcyShop.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL));
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(mCommonNavAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);
        mFragments.add(GoodsListFragment.newInstance("order"));
        mFragments.add(GoodsListFragment.newInstance("distance"));
        mFragments.add(GoodsListFragment.newInstance("star"));
        mFragments.add(GoodsListFragment.newInstance("rank"));
        mVuPagerAdapter = new MainFragmentVuPagerAdapter(getFragmentManager(), mFragments);
        viewPager.setAdapter(mVuPagerAdapter);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }


    @Override
    public void initData() {
        super.initData();
        createGoods();

        ShopAdapter adapter = new ShopAdapter(R.layout.item_goodshop,list);
        rcyShop.setAdapter(adapter);

    }

    private void createGoods(){
        for (int i = 0; i < 4 ; i++) {
            GoodsBean bean = new GoodsBean("露露欢乐超市","意大利进口乐福乸","129","162","1.29km");
            list.add(bean);
        }
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
