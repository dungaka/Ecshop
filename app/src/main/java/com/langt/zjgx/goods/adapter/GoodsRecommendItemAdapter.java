package com.langt.zjgx.goods.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.library.UIUtils;
import com.langt.zjgx.R;
import com.langt.zjgx.home.model.GoodsBean;
import com.langt.zjgx.utils.ScreenUtils;

import org.raphets.roundimageview.RoundImageView;

import java.util.List;

public class GoodsRecommendItemAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {

    public GoodsRecommendItemAdapter(@Nullable List<GoodsBean> data) {
        super(R.layout.item_recommend_goods, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GoodsBean item) {
        LinearLayout ll_rootView = helper.getView(R.id.ll_rootView);
        View view_divide = helper.getView(R.id.view_divide);
        RoundImageView iv_goods_pic = helper.getView(R.id.iv_goods_pic);
        TextView tv_goods_name = helper.getView(R.id.tv_goods_name);
        tv_goods_name.setText("饼干饼干饼干饼干饼干饼干饼干饼干饼干饼干饼干饼干饼干饼干饼干饼干饼干饼干");
    }
}
