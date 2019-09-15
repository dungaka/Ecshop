package com.langt.zjgx.home.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.model.GoodsBean;
import com.langt.zjgx.widget.SnapUpCountDownTimerView;

import org.raphets.roundimageview.RoundImageView;

import java.util.List;

/**
 * 立即参团列表adapter
 */
public class CantuanGoodsListAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {
    public CantuanGoodsListAdapter(@Nullable List<GoodsBean> data) {
        super(R.layout.item_goods_flash_sale, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GoodsBean item) {
        RoundImageView iv_goods_pic = helper.getView(R.id.iv_goods_pic);
        TextView tv_has_sale_count = helper.getView(R.id.tv_has_sale_count);
        SnapUpCountDownTimerView timerView = helper.getView(R.id.timerView);
        helper.setText(R.id.tv_goods_name, "测试商品名称测试商品名称测试商品名称测试商品名称测试商品名称");
        tv_has_sale_count.setText(mContext.getString(R.string.goods_list_xianshiqianggou_has_sale,"10"));
        timerView.start(4 * 24 * 60 * 60 * 1000 + 4 * 60 * 60 * 1000 + 35 * 60 * 1000);
    }
}
