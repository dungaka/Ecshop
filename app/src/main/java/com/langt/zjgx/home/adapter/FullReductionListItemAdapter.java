package com.langt.zjgx.home.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.model.GoodsBean;

import org.raphets.roundimageview.RoundImageView;

import java.util.List;

public class FullReductionListItemAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {
    public FullReductionListItemAdapter(@Nullable List<GoodsBean> data) {
        super(R.layout.item_goods_manjian, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GoodsBean item) {
        RoundImageView iv_goods_pic = helper.getView(R.id.iv_goods_pic);
        helper.setText(R.id.tv_goods_name,"测试商品名称测试商品名称测试商品名称测试商品名称测试商品名称");
    }
}
