package com.langt.zjgx.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MainFragmentVuPagerAdapter;
import com.langt.zjgx.adapter.MyCommonNavigatorAdapter;
import com.langt.zjgx.adapter.RecycleViewDivider;
import com.langt.zjgx.adapter.ShopAdapter;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.home.fragment.HomeRecommendGoodsListFragment;
import com.langt.zjgx.home.presenter.HomePresenter;
import com.langt.zjgx.home.view.IHomeView;
import com.langt.zjgx.message.ui.activity.MessageActivity;
import com.langt.zjgx.model.Banner;
import com.langt.zjgx.model.HomePageBean;
import com.langt.zjgx.model.ShopBean;
import com.langt.zjgx.search.SearchActivity;
import com.langt.zjgx.shop.ShopDetailActivity;
import com.langt.zjgx.utils.ActivityUtils;
import com.langt.zjgx.utils.GlideUtils;
import com.langt.zjgx.utils.ListUtil;
import com.langt.zjgx.widget.banner.BannerAdapter;
import com.langt.zjgx.widget.banner.BannerLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment<HomePresenter>
        implements IHomeView, OnRefreshListener {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.layout_banner)
    BannerLayout bannerLayout;
    @BindView(R.id.rcy_shop)
    RecyclerView rcyShop;
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private ArrayList<Banner> bannerList;
    private BannerAdapter<Banner> mBannerAdapter;

    protected List<ShopBean> shopList = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();
    private MainFragmentVuPagerAdapter mVuPagerAdapter;
    private String[] mTabs = {"下单量", "距离", "店铺星级", "好评率"};

    private ShopAdapter adapter;

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);
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
        initAppBarStatus();
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setOnRefreshListener(this);
        mBannerAdapter = new BannerAdapter<Banner>() {
            @Override
            protected void bind(BannerAdapter.ViewHolder holder, Banner data) {
                String picUrl = data.getPicture();
                GlideUtils.loadImage(HomeFragment.this, picUrl, holder.ivBannerItem);
            }
        };
        bannerLayout.setBannerAdapter(mBannerAdapter);
        // 图片地址测试
        bannerList = new ArrayList<>();
        mBannerAdapter.reset(bannerList);

        rcyShop.setLayoutManager(new LinearLayoutManager(getContext()));

        rcyShop.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL));
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        MyCommonNavigatorAdapter myCommonNavigatorAdapter = new MyCommonNavigatorAdapter(mTabs);
        commonNavigator.setAdapter(myCommonNavigatorAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);
        mFragments.add(HomeRecommendGoodsListFragment.newInstance(Constant.HomeGoodsListOrderType.type_order));
        mFragments.add(HomeRecommendGoodsListFragment.newInstance(Constant.HomeGoodsListOrderType.type_distance));
        mFragments.add(HomeRecommendGoodsListFragment.newInstance(Constant.HomeGoodsListOrderType.type_star_level));
        mFragments.add(HomeRecommendGoodsListFragment.newInstance(Constant.HomeGoodsListOrderType.type_favorable_rate));
        mVuPagerAdapter = new MainFragmentVuPagerAdapter(getFragmentManager(), mFragments);
        viewPager.setAdapter(mVuPagerAdapter);
        ViewPagerHelper.bind(magicIndicator, viewPager);
        myCommonNavigatorAdapter.setOnTabItemClickListener(new MyCommonNavigatorAdapter.OnTabItemClickListener() {
            @Override
            public void onTabItemClick(int position, View view) {
                viewPager.setCurrentItem(position, false);
            }
        });

        adapter = new ShopAdapter(shopList);
        rcyShop.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), ShopDetailActivity.class));
            }
        });
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        presenter.getHomePageInfo();
    }

    /**
     * 加载完成后
     * 解决-->Tablayout+viewpager 刷新数据后不能滑动问题
     */
    private void initAppBarStatus() {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
        behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return true;
            }
        });
    }


    @Override
    public void initData() {
        super.initData();
        presenter.getHomePageInfo();
    }

    @Override
    public void onGetHomePageInfo(HomePageBean homePageBean) {
        if (homePageBean != null) {
            List<Banner> adList = homePageBean.getAdList();
            if (!ListUtil.isEmpty(adList)) {
                bannerList.clear();
                bannerList.addAll(adList);
                mBannerAdapter.reset(bannerList);
            }
            List<ShopBean> shopBeanList = homePageBean.getShopList();
            if (shopBeanList != null && shopBeanList.size() > 0) {
                shopList.clear();
                shopList.addAll(shopBeanList);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @OnClick({R.id.ll_promote_one, R.id.ll_promote_two, R.id.ll_promote_three,
            R.id.ll_promote_four, R.id.ll_promote_five, R.id.iv_message,
            R.id.iv_event_image, R.id.tv_recommend_shop_more, R.id.layout_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_search:
                ActivityUtils.startActivity(SearchActivity.class);
                break;
            case R.id.iv_message:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            case R.id.iv_event_image:  // 中间的活动

                break;
            case R.id.tv_recommend_shop_more: // 推荐好店-更多

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
}
