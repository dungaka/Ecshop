package com.langt.zjgx.shop.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.home.model.GoodsBean;
import com.langt.zjgx.widget.GoodsNumberPicker;

import java.util.List;

/**
 * 店铺页面已选商品列表adapter
 */
public class ShopHasChooseGoodsAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {
    public ShopHasChooseGoodsAdapter(@Nullable List<GoodsBean> data) {
        super(R.layout.item_shop_has_choose_goods, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GoodsBean item) {
        helper.setText(R.id.tv_goods_name, "俄罗斯进口紫皮属");
        helper.setText(R.id.tv_goods_type, "草莓味");
        helper.setText(R.id.tv_goods_price, mContext.getString(R.string.goods_price, "15.6"));
        GoodsNumberPicker number_picker = helper.getView(R.id.number_picker);
        number_picker.setOnNumberChangeListener(new GoodsNumberPicker.OnNumberChangeListener() {
            @Override
            public void onNumberChange(int number) {
                if (number == 0) {
                    // 移除商品
                    int position = helper.getPosition();
                    mData.remove(position);
                    notifyItemRemoved(position);
                }
            }
        });
    }
}
