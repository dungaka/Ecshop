package com.langt.zjgx.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.model.GoodsBean;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {
    public HomeAdapter(int layoutResId, List data) {
        super(layoutResId, data);
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
    }
}