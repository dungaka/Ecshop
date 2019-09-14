package com.langt.zjgx.widget.viewpagerrecyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.langt.zjgx.R;
import com.langt.zjgx.goods.adapter.GoodsDetailRecommendListViewPager;
import com.langt.zjgx.model.GoodsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品推荐列表
 */
public class GoodsRecommendListView extends LinearLayout {
    @BindView(R.id.tv_recommend_title)
    TextView tv_recommend_title;
    @BindView(R.id.viewPager)
    GoodsDetailRecommendListViewPager viewPager;
    @BindView(R.id.indicator)
    PageIndicatorView indicator;
    @BindView(R.id.ll_recommend_layout)
    LinearLayout ll_recommend_layout;
    @BindView(R.id.tv_no_recommend)
    TextView tv_no_recommend;
    @BindView(R.id.tv_show_more)
    TextView tv_show_more;

    public GoodsRecommendListView(Context context) {
        this(context, null);
    }

    public GoodsRecommendListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GoodsRecommendListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, @Nullable AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.widget_goods_recomend_list, this);
        ButterKnife.bind(this);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GoodsRecommendListView);
            String recommendTitle = a.getString(R.styleable.GoodsRecommendListView_recommendTitle);
            if (!TextUtils.isEmpty(recommendTitle)) {
                tv_recommend_title.setText("—— " + recommendTitle + "—— ");
            }
            a.recycle();
        }
    }

    @OnClick({R.id.tv_show_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_show_more:
                if (onMoreClickListener != null) {
                    onMoreClickListener.onMoreClick();
                }
                break;
        }
    }

    private OnMoreClickListener onMoreClickListener;

    public void setOnMoreClickListener(OnMoreClickListener onMoreClickListener) {
        this.onMoreClickListener = onMoreClickListener;
    }

    public interface OnMoreClickListener {
        void onMoreClick();
    }

    /**
     * 设置数据
     */
    public void setItemList(List<GoodsBean> itemList) {
        if (itemList == null) {
            ll_recommend_layout.setVisibility(View.GONE);
            tv_no_recommend.setVisibility(View.VISIBLE);
            tv_show_more.setVisibility(View.GONE);
        } else {
            ll_recommend_layout.setVisibility(View.VISIBLE);
            tv_no_recommend.setVisibility(View.GONE);
            tv_show_more.setVisibility(View.VISIBLE);
            viewPager.init(itemList);
            indicator.initIndicator(viewPager.getPageSize());
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    indicator.setSelectedPage(i);
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });
        }
    }
}
