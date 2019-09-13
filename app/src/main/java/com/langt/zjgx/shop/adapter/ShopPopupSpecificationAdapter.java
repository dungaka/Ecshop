package com.langt.zjgx.shop.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;

import java.util.List;

/**
 * 店铺选取规格弹窗规格的adapter
 */
public class ShopPopupSpecificationAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int selectPosition = 0;

    public ShopPopupSpecificationAdapter(@Nullable List<String> data) {
        super(R.layout.item_goods_specification, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        TextView tv_goods_specification = helper.getView(R.id.tv_goods_specification);
        tv_goods_specification.setText("香辣味");
        tv_goods_specification.setSelected(selectPosition == helper.getPosition());
    }

    public void setSelectPosition(int position){
        this.selectPosition = position;
        notifyDataSetChanged();
    }

    public int getSelectPosition() {
        return selectPosition;
    }
}
