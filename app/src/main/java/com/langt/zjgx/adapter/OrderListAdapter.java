package com.langt.zjgx.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.mine.model.OrderListBean;

import java.util.List;

public class OrderListAdapter extends BaseQuickAdapter<OrderListBean, BaseViewHolder> {
    public OrderListAdapter(@Nullable List<OrderListBean> data) {
        super(R.layout.item_order,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, OrderListBean item) {

    }
}
