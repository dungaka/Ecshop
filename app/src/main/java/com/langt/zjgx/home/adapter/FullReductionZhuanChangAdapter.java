package com.langt.zjgx.home.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.goods.GoodsDetailActivity;
import com.langt.zjgx.home.FullReductionZhuanChangFullActivity;
import com.langt.zjgx.model.GoodsBean;
import com.langt.zjgx.model.ShopBean;

import org.raphets.roundimageview.RoundImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 满减列表adapter
 */
public class FullReductionZhuanChangAdapter extends BaseQuickAdapter<ShopBean, BaseViewHolder> {
    public FullReductionZhuanChangAdapter(@Nullable List<ShopBean> data) {
        super(R.layout.item_full_reduction_zhuan_chang, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ShopBean item) {
        RoundImageView iv_shop_image = helper.getView(R.id.iv_shop_image);
        TextView tv_look_more = helper.getView(R.id.tv_look_more);
        helper.setText(R.id.tv_shop_name, "天天超市");
        helper.setText(R.id.tv_shop_manjian_info, "满999减666");
        RecyclerView recyclerView = helper.getView(R.id.recyclerView);

        List<GoodsBean> itemList = new ArrayList<>();
        FullReductionListItemAdapter itemAdapter = new FullReductionListItemAdapter(itemList);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mContext.startActivity(new Intent(mContext, GoodsDetailActivity.class));
            }
        });

        tv_look_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, FullReductionZhuanChangFullActivity.class));
            }
        });

        for (int i = 0; i < 3; i++) {
            itemList.add(new GoodsBean(""));
        }
        itemAdapter.notifyDataSetChanged();
    }
}
