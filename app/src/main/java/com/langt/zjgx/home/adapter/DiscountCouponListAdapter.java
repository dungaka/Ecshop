package com.langt.zjgx.home.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.home.model.ShopBean;

import java.util.List;

public class DiscountCouponListAdapter extends BaseQuickAdapter<ShopBean, BaseViewHolder> {
    public DiscountCouponListAdapter(@Nullable List<ShopBean> data) {
        super(R.layout.item_discount_coupon_shop_info, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ShopBean item) {
        helper.setText(R.id.tv_shop_name,"天天回家超市");
        helper.setText(R.id.tv_shop_location,"河南省郑州市金水区河南省中医院内，河南中医院第二附属医院-2住院部西");
        helper.setText(R.id.tv_shop_distance,"1.05km");
        AppCompatRatingBar ratingBar = helper.getView(R.id.ratingBar);
        RecyclerView recyclerView = helper.getView(R.id.recyclerView);
    }
}
