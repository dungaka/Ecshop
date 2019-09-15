package com.langt.zjgx.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.adapter.HomeRecommendGoodsAdapter;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.goods.GoodsDetailActivity;
import com.langt.zjgx.home.presenter.HomeRecommendGoodsListPresenter;
import com.langt.zjgx.home.view.IHomeRecommendGoodsView;
import com.langt.zjgx.model.GoodsBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeRecommendGoodsListFragment extends BaseFragment<HomeRecommendGoodsListPresenter>
        implements IHomeRecommendGoodsView, OnLoadMoreListener {

    public static final String TYPE = "TYPE";

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private String type;

    private int nowPage = 1, totalPage;

    protected List<GoodsBean> list;
    private HomeRecommendGoodsAdapter adapter;

    @Override
    protected HomeRecommendGoodsListPresenter createPresenter() {
        return new HomeRecommendGoodsListPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_only_recyclerview_padding_10;
    }


    public static HomeRecommendGoodsListFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString(TYPE, type);
        HomeRecommendGoodsListFragment fragment = new HomeRecommendGoodsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        if (getArguments() != null) {
            type = getArguments().getString(TYPE, "order");
        }
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setOnLoadMoreListener(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        list = new ArrayList<>();
        adapter = new HomeRecommendGoodsAdapter(list, type);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                GoodsBean goodsBean = list.get(position);
                GoodsDetailActivity.startActivity(getActivity(), goodsBean.getShopId(), goodsBean.getGoodsId(), goodsBean.getShopType());
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        presenter.getHomeRecommendGoodsList(type, nowPage);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        nowPage++;
        presenter.getHomeRecommendGoodsList(type, nowPage);
    }

    @Override
    public void onGetGoodsList(List<GoodsBean> goodsBeanList) {
        refreshLayout.finishLoadMore();
        if (goodsBeanList != null && goodsBeanList.size() > 0) {
            list.clear();
            list.addAll(goodsBeanList);
            adapter.notifyDataSetChanged();
        }
    }
}
