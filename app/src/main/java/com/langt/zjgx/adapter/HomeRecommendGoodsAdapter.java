package com.langt.zjgx.adapter;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatRatingBar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.model.GoodsBean;
import com.langt.zjgx.utils.GlideUtils;

import org.raphets.roundimageview.RoundImageView;

import java.util.List;

/**
 * 首页推荐商品列表adapter
 */
public class HomeRecommendGoodsAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {
    private String type;

    public HomeRecommendGoodsAdapter(List<GoodsBean> data, String type) {
        super(R.layout.item_home_recommend_goods_grid, data);
        this.type = type;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GoodsBean item) {
        RoundImageView iv_goods_pic = helper.getView(R.id.iv_goods_pic);
        // 抢购，拼团的标识图片
        ImageView tv_goods_event_flag = helper.getView(R.id.tv_goods_event_flag);
        // 搜索结果 商品价格 右边的距离
        TextView tv_price_right_distance = helper.getView(R.id.tv_price_right_distance);
        // 单买价
        TextView tv_single_buy_price = helper.getView(R.id.tv_single_buy_price);
        tv_single_buy_price.setText("单买价：￥19.00");
        // 原价
        TextView tv_goods_original_price = helper.getView(R.id.tv_goods_original_price);
        tv_goods_original_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        if (!TextUtils.isEmpty(item.getGoodsOrigPrice())) {
            tv_goods_original_price.setText(mContext.getString(R.string.goods_price, item.getGoodsOrigPrice()));
        }
        // 距离
        TextView tv_distance = helper.getView(R.id.tv_distance);
        // 已售
        TextView tv_goods_sale_count = helper.getView(R.id.tv_goods_sale_count);
        // 好评率
        TextView tv_favorable_rate = helper.getView(R.id.tv_favorable_rate);
        // 评级
        LinearLayout ll_pingji = helper.getView(R.id.ll_pingji);
        AppCompatRatingBar ratingBar = helper.getView(R.id.ratingBar);

        switch (type) {
            case Constant.HomeGoodsListOrderType.type_order:
                tv_goods_sale_count.setVisibility(View.VISIBLE);
                tv_goods_sale_count.setText(mContext.getString(R.string.goods_list_xianshiqianggou_has_sale, String.valueOf(item.getGoodsSales())));
                break;
            case Constant.HomeGoodsListOrderType.type_distance:
                tv_distance.setVisibility(View.VISIBLE);
                tv_distance.setText(mContext.getString(R.string.goods_list_shop_distance, item.getShopDistance()));
                break;
            case Constant.HomeGoodsListOrderType.type_star_level:
                ll_pingji.setVisibility(View.VISIBLE);
                ratingBar.setRating(item.getShopScore() * 5);
                break;
            case Constant.HomeGoodsListOrderType.type_favorable_rate:
                tv_favorable_rate.setVisibility(View.VISIBLE);
                tv_favorable_rate.setText(mContext.getString(R.string.goods_list_shop_favorable_rate,item.getGoodsScore()));
                break;
            case Constant.HomeGoodsListOrderType.type_search:
                tv_price_right_distance.setVisibility(View.VISIBLE);
                break;
        }

        GlideUtils.loadImage(mContext, item.getGoodsImg(), iv_goods_pic);
        helper.setText(R.id.tv_goods_name, item.getGoodsName());  // 商品名称
        helper.setText(R.id.tv_goods_price, item.getGoodsCurPrice());  // 价格
        helper.setText(R.id.tv_goods_unit, mContext.getString(R.string.goods_goods_unit, item.getGoodsUnit()));  // 单位
        tv_price_right_distance.setText(item.getShopDistance());  // 距离


    }
}