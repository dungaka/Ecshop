package com.langt.zjgx.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.goods.GoodsDetailActivity;
import com.langt.zjgx.home.adapter.CantuanGoodsListAdapter;
import com.langt.zjgx.model.GoodsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 立即参团列表
 */
public class CanTuanGoodsListFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener{
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static final String TYPE = "TYPE";
    private String type;

    private List<GoodsBean> mDatas;
    private CantuanGoodsListAdapter adapter;

    public static CanTuanGoodsListFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString(TYPE, type);
        CanTuanGoodsListFragment fragment = new CanTuanGoodsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_only_recyclerview;
    }

    @Override
    public void initView(View view) {
        if (getArguments() != null) {
            type = getArguments().getString(TYPE, "");
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mDatas = new ArrayList<>();
        adapter = new CantuanGoodsListAdapter(mDatas);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        for (int i = 0; i < 4; i++) {
            mDatas.add(new GoodsBean(""));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity(new Intent(getActivity(), GoodsDetailActivity.class));
    }
}
