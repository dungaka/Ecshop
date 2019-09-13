package com.langt.zjgx.home.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.home.model.DiscountCouponBean;
import com.langt.zjgx.home.model.ShopBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 免费领券列表adapter
 */
public class DiscountCouponListAdapter extends BaseQuickAdapter<ShopBean, BaseViewHolder> {
    // 是否显示店铺信息
    private boolean isShowShopInfo;

    public DiscountCouponListAdapter(@Nullable List<ShopBean> data, boolean isShowShopInfo) {
        super(R.layout.item_discount_coupon_shop_info, data);
        this.isShowShopInfo = isShowShopInfo;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ShopBean item) {
        LinearLayout ll_shop_info = helper.getView(R.id.ll_shop_info);
        ll_shop_info.setVisibility(isShowShopInfo ? View.VISIBLE : View.GONE);
        helper.setText(R.id.tv_shop_name, "天天回家超市");
        helper.setText(R.id.tv_shop_location, "河南省郑州市金水区河南省中医院内，河南中医院第二附属医院-2住院部西");
        helper.setText(R.id.tv_shop_distance, "1.05km");
        AppCompatRatingBar ratingBar = helper.getView(R.id.ratingBar);
        ratingBar.setRating(4);
        RecyclerView recyclerView = helper.getView(R.id.recyclerView);

        List<DiscountCouponBean> couponBeanList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            couponBeanList.add(new DiscountCouponBean());
        }
        DiscountCouponListItemAdapter itemAdapter = new DiscountCouponListItemAdapter(couponBeanList);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(itemAdapter);
    }
}
