package com.langt.zjgx.order.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.model.GoodsBean;

import java.util.List;

/**
 * 确认订单页面-商品列表adapter
 */
public class ConfirmOrderGoodsListAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {
    public ConfirmOrderGoodsListAdapter(@Nullable List<GoodsBean> data) {
        super(R.layout.item_confirm_order_goods_list, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GoodsBean item) {
        helper.setText(R.id.tv_goods_name, "03绿树果南非西柚新鲜红心葡萄柚孕妇水果应季蜜柚产地");
        helper.setText(R.id.tv_goods_specification, mContext.getString(R.string.confirm_order_specification, "GXZ-J618"));
        helper.setText(R.id.tv_goods_price, mContext.getString(R.string.goods_price, "255.6"));
        helper.setText(R.id.tv_goods_count, "x1");
    }
}
