package com.langt.zjgx.adapter;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.mine.model.CollectGoodsBean;

import java.util.List;

public class CollectGoodsAdapter extends BaseQuickAdapter<CollectGoodsBean, BaseViewHolder> {


    public CollectGoodsAdapter(int layoutResId, @Nullable List<CollectGoodsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CollectGoodsBean item) {



    }
}
