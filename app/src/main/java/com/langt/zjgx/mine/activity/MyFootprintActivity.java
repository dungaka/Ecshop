package com.langt.zjgx.mine.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.FootprintAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.mine.model.CollectGoodsBean;

import java.util.ArrayList;

import butterknife.BindView;

public class MyFootprintActivity extends BaseActivity {


    @BindView(R.id.include_recyclerview)
    RecyclerView recyclerView;

    FootprintAdapter adapter;
    private ArrayList<CollectGoodsBean> list;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_footprint;
    }

    @Override
    public void initView() {

        createData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FootprintAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void createData(){
        list = new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            CollectGoodsBean bean = new CollectGoodsBean();
            list.add(bean);
        }
    }
}
