package com.langt.zjgx.shop.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.model.GoodsBean;

import org.raphets.roundimageview.RoundImageView;

import java.util.List;

/**
 * 店铺详情页面商品列表adapter
 */
public class ShopDetailGoodsListAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {
    public ShopDetailGoodsListAdapter(@Nullable List<GoodsBean> data) {
        super(R.layout.item_shop_detail_goods_list, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GoodsBean item) {
        RoundImageView iv_goods_pic = helper.getView(R.id.iv_goods_pic);
        TextView tv_goods_name = helper.getView(R.id.tv_goods_name);
        TextView tv_goods_price = helper.getView(R.id.tv_goods_price);
        TextView tv_shop_seal_num = helper.getView(R.id.tv_shop_seal_num);
//        TextView tv_choose_specification = helper.getView(R.id.tv_choose_specification);

        tv_goods_name.setText("03绿树果南非西柚新鲜红心葡萄柚孕妇水果应季蜜柚产地.");
        tv_goods_price.setText(mContext.getString(R.string.goods_price,"125.00"));
        tv_shop_seal_num.setText(mContext.getString(R.string.shop_goods_seal_count,"125.00"));

        helper.addOnClickListener(R.id.tv_choose_specification);
    }
}
