package com.langt.zjgx.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.mine.model.CollectGoodsBean;

import java.util.List;

public class FootprintAdapter extends BaseQuickAdapter<CollectGoodsBean,BaseViewHolder> {


    public FootprintAdapter(@Nullable List<CollectGoodsBean> data) {
        super(R.layout.item_footprint,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CollectGoodsBean item) {

    }
}
