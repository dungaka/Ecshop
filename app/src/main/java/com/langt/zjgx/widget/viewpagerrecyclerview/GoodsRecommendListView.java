package com.langt.zjgx.widget.viewpagerrecyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.langt.zjgx.R;
import com.langt.zjgx.goods.adapter.GoodsRecommendItemAdapter;
import com.langt.zjgx.home.model.GoodsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品推荐列表
 */
public class GoodsRecommendListView extends LinearLayout implements PagingScrollHelper.onPageChangeListener {
    @BindView(R.id.tv_recommend_title)
    TextView tv_recommend_title;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.indicator)
    PageIndicatorView indicator;

    private List<GoodsBean> itemList;
    private GoodsRecommendItemAdapter adapter;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();

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

        itemList = new ArrayList<>();
        adapter = new GoodsRecommendItemAdapter(itemList);
        mRecyclerView.setAdapter(adapter);
        HorizontalPageLayoutManager horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, 3);
        mRecyclerView.addItemDecoration(new PagingItemDecoration(context,horizontalPageLayoutManager));
        scrollHelper.setUpRecycleView(mRecyclerView);
        scrollHelper.setOnPageChangeListener(this);
        mRecyclerView.setLayoutManager(horizontalPageLayoutManager);
        mRecyclerView.setHorizontalScrollBarEnabled(true);
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

    @Override
    public void onPageChange(int index) {
        indicator.setSelectedPage(index);
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
            return;
        }
        this.itemList.clear();
        this.itemList.addAll(itemList);
        adapter.notifyDataSetChanged();
        scrollHelper.updateLayoutManger();
        scrollHelper.scrollToPosition(0);
        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                indicator.initIndicator(scrollHelper.getPageCount());
            }
        });
    }
}
