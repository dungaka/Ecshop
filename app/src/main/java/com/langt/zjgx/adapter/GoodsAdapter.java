package com.langt.zjgx.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.goods.GoodsDetailActivity;
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

        helper.getView(R.id.rootView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, GoodsDetailActivity.class));
            }
        });

    }
}