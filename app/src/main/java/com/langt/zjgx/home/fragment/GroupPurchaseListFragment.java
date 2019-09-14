package com.langt.zjgx.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.goods.GoodsDetailActivity;
import com.langt.zjgx.home.adapter.GroupPurchaseListAdapter;
import com.langt.zjgx.model.GoodsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GroupPurchaseListFragment extends BaseFragment {
    public static final String TYPE = "TYPE";
    @BindView(R.id.comm_recycleview)
    RecyclerView recyclerView;

    private String type;

    private List<GoodsBean> goodsBeanList;
    private GroupPurchaseListAdapter adapter;

    public static GroupPurchaseListFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString(TYPE, type);
        GroupPurchaseListFragment fragment = new GroupPurchaseListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_group_purchase_list;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        goodsBeanList = new ArrayList<>();
        adapter = new GroupPurchaseListAdapter(goodsBeanList);
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
        if (getArguments() != null) {
            type = getArguments().getString(TYPE, "");
        }
        for (int i = 0; i < 5; i++) {
            goodsBeanList.add(new GoodsBean(""));
        }
        adapter.notifyDataSetChanged();
    }
}
