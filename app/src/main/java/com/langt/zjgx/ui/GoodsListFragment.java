package com.langt.zjgx.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.adapter.HomeRecommendGoodsAdapter;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.goods.GoodsDetailActivity;
import com.langt.zjgx.home.model.GoodsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoodsListFragment extends BaseFragment {

    public static final String TYPE = "TYPE";

    @BindView(R.id.comm_recycleview)
    RecyclerView recyclerView;
    private String type;

    protected List<GoodsBean> list;
    private HomeRecommendGoodsAdapter adapter;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_recycleview;
    }


    public static GoodsListFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString(TYPE, type);
        GoodsListFragment fragment = new GoodsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        if (getArguments() != null) {
            type = getArguments().getString(TYPE, "order");
        }
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        list = new ArrayList<>();
        adapter = new HomeRecommendGoodsAdapter(list, type);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), GoodsDetailActivity.class));
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        for (int i = 0; i < 5; i++) {
            list.add(new GoodsBean(""));
        }
        resetView();
    }

    private void resetView() {
        switch (type) {
            case Constant.HomeGoodsListOrderType.type_order:
            case Constant.HomeGoodsListOrderType.type_distance:
            case Constant.HomeGoodsListOrderType.type_star_level:
            case Constant.HomeGoodsListOrderType.type_favorable_rate:
            default:
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
