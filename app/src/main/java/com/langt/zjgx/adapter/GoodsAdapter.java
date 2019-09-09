package com.langt.zjgx.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.home.model.GoodsBean;

import java.util.List;

public class GoodsAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {

    boolean isShowData;
    public GoodsAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }
    public GoodsAdapter(int layoutResId, List data,boolean isShowData) {
        super(layoutResId, data);
        this.isShowData = isShowData;
    }

//    @Override
//    protected void convert(BaseViewHolder helper, GoodsBean item) {
//        helper.setText(R.id.text, item.getTitle());
//        helper.setImageResource(R.id.icon, item.getImageResource());
//        // 加载网络图片
//      Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
//    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GoodsBean item) {
        helper.setText(R.id.tv_distance,item.getDistance());
        helper.setText(R.id.tv_goods_name,item.getGoodsInfo());
        helper.setText(R.id.tv_price,item.getGoodsPrice());
    }
}