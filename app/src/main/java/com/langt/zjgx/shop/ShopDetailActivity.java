package com.langt.zjgx.shop;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.goods.GoodsDetailActivity;
import com.langt.zjgx.home.model.Banner;
import com.langt.zjgx.home.model.GoodsBean;
import com.langt.zjgx.shop.adapter.ShopDetailGoodsListAdapter;
import com.langt.zjgx.shop.fragment.ChooseGoodsSpecificationDialogFragment;
import com.langt.zjgx.widget.banner.BannerAdapter;
import com.langt.zjgx.widget.banner.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * 店铺详情
 */
public class ShopDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title_center)
    TextView tv_title_center;
    @BindView(R.id.layout_banner)
    BannerLayout bannerLayout;

    @BindView(R.id.tablayout)
    VerticalTabLayout tabLayout;
    @BindView(R.id.rv_goods_list)
    RecyclerView rv_goods_list;

    private BannerAdapter<Banner> mBannerAdapter;

    private List<GoodsBean> goodsBeanList;
    private ShopDetailGoodsListAdapter goodsListAdapter;

    private String[] tabs = {"休闲零食","蔬果生鲜","百  货","母婴精品","童装鞋帽","居家百货"};

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_detail;
    }

    @Override
    public void initView() {
        mBannerAdapter = new BannerAdapter<Banner>() {
            @Override
            protected void bind(BannerAdapter.ViewHolder holder, Banner data) {
//                GlideUtils.loadBanner(data.getPicture(), holder.ivBannerItem);
                Glide.with(ShopDetailActivity.this)
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

        createTabs();

        initGoodsListView();
    }

    private void createTabs() {
        tabLayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return tabs.length;
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return new ITabView.TabTitle.Builder().setContent(tabs[position]).build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });

        tabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                tab.getTitleView().setTextColor(getResources().getColor(R.color.colortheme));
                tab.getTitleView().setBackgroundColor(getResources().getColor(R.color.white));
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

    }

    private void initGoodsListView(){
        rv_goods_list.setLayoutManager(new LinearLayoutManager(this));
        goodsBeanList = new ArrayList<>();
        goodsListAdapter = new ShopDetailGoodsListAdapter(goodsBeanList);
        rv_goods_list.setAdapter(goodsListAdapter);
        goodsListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(ShopDetailActivity.this, GoodsDetailActivity.class));
            }
        });
        goodsListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.tv_choose_specification) {
                    // 显示选择商品规格的弹窗
                    ChooseGoodsSpecificationDialogFragment dialogFragment = new ChooseGoodsSpecificationDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(),"dialogFragment");
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            goodsBeanList.add(new GoodsBean(""));
        }
        goodsListAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.tv_enter_shop})
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.tv_enter_shop:
                startActivity(new Intent(this,ShopBaseInfoActivity.class));
                break;
        }
    }
}
