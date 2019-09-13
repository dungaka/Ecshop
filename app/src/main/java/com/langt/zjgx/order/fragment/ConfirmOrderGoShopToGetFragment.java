package com.langt.zjgx.order.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.goods.GoodsDetailActivity;
import com.langt.zjgx.home.model.GoodsBean;
import com.langt.zjgx.order.ChooseDiscountCouponActivity;
import com.langt.zjgx.order.adapter.ConfirmOrderGoodsListAdapter;
import com.langt.zjgx.widget.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 确认订单-到店自取页面
 */
public class ConfirmOrderGoShopToGetFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private List<GoodsBean> itemList;
    private ConfirmOrderGoodsListAdapter adapter;

    public static ConfirmOrderGoShopToGetFragment newInstance() {

        Bundle args = new Bundle();
        ConfirmOrderGoShopToGetFragment fragment = new ConfirmOrderGoShopToGetFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_confirm_order_go_shop_go_get;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemList = new ArrayList<>();
        adapter = new ConfirmOrderGoodsListAdapter(itemList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerDecoration(getActivity()));
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
        itemList.add(new GoodsBean(""));
        adapter.notifyDataSetChanged();
    }

    @OnClick({R.id.rl_discount_coupon})
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.rl_discount_coupon:
                startActivity(new Intent(getActivity(), ChooseDiscountCouponActivity.class));
                break;
        }
    }
}
