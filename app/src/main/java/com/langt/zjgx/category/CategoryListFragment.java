package com.langt.zjgx.category;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.GoodsAdapter;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.model.GoodsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CategoryListFragment extends BaseFragment {

    @BindView(R.id.rcv_category)
    RecyclerView recyclerView;


    protected List<GoodsBean> list = new ArrayList<>();
    GoodsAdapter adapter;
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_categorylist;
    }


    public static CategoryListFragment newInstance() {

        Bundle args = new Bundle();

        CategoryListFragment fragment = new CategoryListFragment();
        fragment.setArguments(args);
        return fragment;
    }



    public void notifyData(String type){
        createGoods(type);
        if(adapter!=null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void initData() {

        createGoods("");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter = new GoodsAdapter(R.layout.item_goods_grid,list);
        recyclerView.setAdapter(adapter);
    }

    private void createGoods(String type){
        for (int i = 0; i < 9 ; i++) {
            GoodsBean bean = new GoodsBean("");
            list.add(bean);
        }
    }

}
