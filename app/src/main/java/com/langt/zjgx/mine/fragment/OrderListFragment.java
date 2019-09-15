package com.langt.zjgx.mine.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.OrderListAdapter;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.mine.model.OrderListBean;
import com.langt.zjgx.mine.presenter.OrderListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderListFragment extends BaseFragment<OrderListPresenter> {

    @BindView(R.id.include_recyclerview)
    RecyclerView recyclerView;

    OrderListAdapter adapter;
    protected List<OrderListBean> list = new ArrayList<>();
    String type;


    public static OrderListFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString("type",type);
        OrderListFragment fragment = new OrderListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected OrderListPresenter createPresenter() {
        return new OrderListPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_orderlist;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        createData();
        String pageType = getArguments().getString("type");

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new OrderListAdapter(list);
        recyclerView.setAdapter(adapter);

    }


    private void createData(){
        for (int i = 0; i < 7; i++) {
            OrderListBean bean = new OrderListBean();
            list.add(bean);
        }
    }
}
