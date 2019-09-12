package com.langt.zjgx.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MainFragmentVuPagerAdapter;
import com.langt.zjgx.adapter.MyCommonNavigatorAdapter;
import com.langt.zjgx.adapter.RecycleViewDivider;
import com.langt.zjgx.adapter.ShopAdapter;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.model.Banner;
import com.langt.zjgx.home.model.GoodsBean;
import com.langt.zjgx.message.ui.activity.MessageActivity;
import com.langt.zjgx.shop.ShopDetailActivity;
import com.langt.zjgx.ui.GoodsListFragment;
import com.langt.zjgx.widget.banner.BannerAdapter;
import com.langt.zjgx.widget.banner.BannerLayout;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

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
    private String[] mTabs = {"下单量", "距离", "店铺星级", "好评率"};

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
                Glide.with(HomeFragment.this)
                        .load("https://img.zcool.cn/community/01acaf5722af116ac7253812b32635.jpg@1280w_1l_2o_100sh.jpg")
                        .into(holder.ivBannerItem);
            }
        };
        bannerLayout.setBannerAdapter(mBannerAdapter);

        // 图片地址测试
        ArrayList<Banner> bannerList = new ArrayList<>();
        bannerList.add(new Banner());
        bannerList.add(new Banner());
        bannerList.add(new Banner());
        bannerList.add(new Banner());
        mBannerAdapter.reset(bannerList);


        rcyShop.setLayoutManager(new LinearLayoutManager(getContext()));

        rcyShop.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL));
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        MyCommonNavigatorAdapter myCommonNavigatorAdapter = new MyCommonNavigatorAdapter(mTabs);
        commonNavigator.setAdapter(myCommonNavigatorAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);
        mFragments.add(GoodsListFragment.newInstance("order"));
        mFragments.add(GoodsListFragment.newInstance("distance"));
        mFragments.add(GoodsListFragment.newInstance("star"));
        mFragments.add(GoodsListFragment.newInstance("rank"));
        mVuPagerAdapter = new MainFragmentVuPagerAdapter(getFragmentManager(), mFragments);
        viewPager.setAdapter(mVuPagerAdapter);
        ViewPagerHelper.bind(magicIndicator, viewPager);
        myCommonNavigatorAdapter.setOnTabItemClickListener(new MyCommonNavigatorAdapter.OnTabItemClickListener() {
            @Override
            public void onTabItemClick(int position, View view) {
                viewPager.setCurrentItem(position, false);
            }
        });
    }


    @Override
    public void initData() {
        super.initData();
        createGoods();

        ShopAdapter adapter = new ShopAdapter(R.layout.item_goodshop, list);
        rcyShop.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), ShopDetailActivity.class));
            }
        });

    }

    @OnClick({R.id.ll_promote_one, R.id.ll_promote_two, R.id.ll_promote_three,
            R.id.ll_promote_four, R.id.ll_promote_five,R.id.iv_message})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_message:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            case R.id.ll_promote_one: // 多人拼
                startActivity(new Intent(getActivity(), GroupPurchaseActivity.class));
                break;
            case R.id.ll_promote_two: // 限时抢购
                startActivity(new Intent(getActivity(), FlashSaleListActivity.class));
                break;
            case R.id.ll_promote_three: // 满减专场
                startActivity(new Intent(getActivity(), FullReductionZhuanChangActivity.class));
                break;
            case R.id.ll_promote_four: // 厂家直销
                startActivity(new Intent(getActivity(), FactoryDirectSaleActivity.class));
                break;
            case R.id.ll_promote_five: // 优惠券
                startActivity(new Intent(getActivity(), DiscountCouponListActivity.class));
                break;
        }
    }

    private void createGoods() {
        for (int i = 0; i < 4; i++) {
            GoodsBean bean = new GoodsBean("露露欢乐超市", "意大利进口乐福乸", "129", "162", "1.29km");
            list.add(bean);
        }
    }
}
