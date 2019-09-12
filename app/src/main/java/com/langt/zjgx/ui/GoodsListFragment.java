package com.langt.zjgx.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.GoodsAdapter;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.model.GoodsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoodsListFragment extends BaseFragment {

    public static final String TYPE = "TYPE";

    @BindView(R.id.comm_recycleview)
    RecyclerView recyclerView;
    private String type;

    protected List<GoodsBean> list = new ArrayList<>();

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
        args.putString(TYPE,type);
        GoodsListFragment fragment = new GoodsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        super.initData();
        type = getArguments().getString(TYPE,"");
        createGoods();


        resetView();
//        HomeAdapter adapter = new HomeAdapter(R.layout.item_goodshop,list);
//        recyclerView.setAdapter(adapter);
    }

    private void resetView() {
        switch (type){
            case "order":
            case "distance":
            case "star":
            case "rank":
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                GoodsAdapter adapter = new GoodsAdapter(R.layout.item_goods_grid,list);
                adapter.setEnableLoadMore(true);
                recyclerView.setAdapter(adapter);
                break;
        }
    }

    private void createGoods(){
        for (int i = 0; i < 9 ; i++) {
            GoodsBean bean = new GoodsBean(type+"露露欢乐超市","意大利进口乐福乸","129","162","1.29km");
            list.add(bean);
        }
    }

}
