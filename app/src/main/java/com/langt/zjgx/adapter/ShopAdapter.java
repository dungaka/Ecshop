package com.langt.zjgx.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.model.ShopBean;
import com.langt.zjgx.utils.GlideUtils;

import java.util.List;

/**
 * 首页-店铺adapter
 */
public class ShopAdapter extends BaseQuickAdapter<ShopBean, BaseViewHolder> {
    public ShopAdapter(List<ShopBean> data) {
        super(R.layout.item_goodshop, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ShopBean item) {
        ImageView iv_goods = helper.getView(R.id.iv_goods);
        TextView tv_goods_type_tip = helper.getView(R.id.tv_goods_type_tip);
        AppCompatRatingBar ratingBar = helper.getView(R.id.ratingBar);
        ratingBar.setRating(item.getShopScore() * 5);
        GlideUtils.loadImage(mContext, item.getShopLogo(), iv_goods);
        helper.setText(R.id.tv_shop_name, item.getShopName());
        helper.setText(R.id.tv_goods_info, item.getGoodsName());
        helper.setText(R.id.tv_goods_price, item.getMinPrice());
        helper.setText(R.id.tv_distance, item.getShopDistance());
        helper.setText(R.id.tv_sell_num, mContext.getString(R.string.goods_list_xianshiqianggou_has_sale,
                String.valueOf(item.getShopSales())));


        switch (item.getShopType()) {
            case Constant.ShopRecommendGoodsType.type_3:
                tv_goods_type_tip.setVisibility(View.VISIBLE);
                tv_goods_type_tip.setText("抢购");
                break;
            case Constant.ShopRecommendGoodsType.type_5:
                tv_goods_type_tip.setVisibility(View.VISIBLE);
                tv_goods_type_tip.setText(item.getPnum());
                break;
            default:
                tv_goods_type_tip.setVisibility(View.GONE);
                break;
        }


    }
}