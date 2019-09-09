package com.langt.zjgx.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.home.model.GoodsBean;

import java.util.List;

public class CartGoodsAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {

    boolean isShowData;
    public CartGoodsAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, GoodsBean item) {
        helper.setText(R.id.text_goods_name,item.getShopName());
    }
}