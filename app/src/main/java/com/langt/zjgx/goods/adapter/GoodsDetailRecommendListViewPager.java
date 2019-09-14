package com.langt.zjgx.goods.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.goods.GoodsDetailActivity;
import com.langt.zjgx.model.GoodsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品详情页面-推荐商品的列表adapter
 */
public class GoodsDetailRecommendListViewPager extends ViewPager {
    private Context context;
    private static final int PAGE_ITEM_SIZE = 3;

    private List<GoodsBean> groupEntities;
    private PagerAdapter pagerAdapter;

    private List<View> viewpages;

    public GoodsDetailRecommendListViewPager(Context context) {
        this(context, null);
    }

    public GoodsDetailRecommendListViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void init(List<GoodsBean> moreItemList) {
        if (moreItemList == null) {
            throw new RuntimeException("moreItemList cannot be null");
        }
        this.groupEntities = moreItemList;
        viewpages = new ArrayList<>();
        for (int i = 0; i < getPageSize(); i++) {
            List<View> gridViews;
            if (groupEntities.size() < (i + 1) * PAGE_ITEM_SIZE) {
                gridViews = getGroupGridViews(groupEntities.subList(i * PAGE_ITEM_SIZE, groupEntities.size()));
            } else {
                gridViews = getGroupGridViews(groupEntities.subList(i * PAGE_ITEM_SIZE, (i + 1) * PAGE_ITEM_SIZE));
            }
            viewpages.addAll(gridViews);
        }
        pagerAdapter = new GoodsDetailRecommendViewPagerAdapter(viewpages);
        setAdapter(pagerAdapter);
    }

    public int getPageSize() {
        if (groupEntities.size() <= PAGE_ITEM_SIZE) {
            return 1;
        } else {
            return groupEntities.size() / PAGE_ITEM_SIZE + 1;
        }
    }

    /**
     * 获取表情组的gridview list
     *
     */
    public List<View> getGroupGridViews(List<GoodsBean> goodsBeanList) {
        List<View> views = new ArrayList<>();
        View view = View.inflate(context, R.layout.layout_goods_detail_recommend_gridview, null);
        RecyclerView gv = view.findViewById(R.id.gridView);
        gv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        final GoodsRecommendItemAdapter gridAdapter = new GoodsRecommendItemAdapter(goodsBeanList);
        gv.setAdapter(gridAdapter);
        gridAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                context.startActivity(new Intent(context, GoodsDetailActivity.class));
            }
        });
        views.add(view);
        return views;
    }
}
