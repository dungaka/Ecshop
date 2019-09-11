package com.langt.zjgx.home.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.home.model.DisountCouponBean;

import java.util.List;

/**
 * 优惠券列表item
 */
public class DiscountCouponListItemAdapter extends BaseQuickAdapter<DisountCouponBean, BaseViewHolder> {
    public DiscountCouponListItemAdapter(@Nullable List<DisountCouponBean> data) {
        super(R.layout.item_discount_coupon, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DisountCouponBean item) {
        helper.setText(R.id.tv_goods_price, "129.0");
        helper.setText(R.id.tv_use_condition, "满20.0可使用");
        helper.setText(R.id.tv_use_address, "全场可用");
        helper.setText(R.id.tv_use_validity, mContext.getString(R.string.discount_coupon_validity_duration, "2019.02.19  15:22:00 - 2019.02.19  15:22:00"));
        TextView tv_discount_coupon_use_or_receive = helper.getView(R.id.tv_discount_coupon_use_or_receive);
    }
}
