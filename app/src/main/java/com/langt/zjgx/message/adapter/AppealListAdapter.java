package com.langt.zjgx.message.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.message.bean.AppealBean;

import java.util.List;

/**
 * 申诉类型adapter
 */
public class AppealListAdapter extends BaseQuickAdapter<AppealBean, BaseViewHolder> {
    /**
     * 申诉类型，0-待处理 1-已处理
     */
    private String appealType;

    public AppealListAdapter(String appealType, @Nullable List<AppealBean> data) {
        super(R.layout.item_appeal_list, data);
        this.appealType = appealType;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, AppealBean item) {
        helper.setText(R.id.tv_appeal_type, "【虚假消息】");
        helper.setText(R.id.tv_appeal_title, "商品不一致，商品有误商品不一致，商品有误商品不一致，商品有误");
        helper.setText(R.id.tv_appeal_submit_time, "11:56");
    }
}
