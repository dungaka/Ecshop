package com.langt.zjgx.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.utils.DisplayUtil;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class MyCommonNavigatorAdapter extends CommonNavigatorAdapter {
    private String[] mTabs;

    public MyCommonNavigatorAdapter(String[] mTabs) {
        this.mTabs = mTabs;
    }

    @Override
    public int getCount() {
        return mTabs.length;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
        simplePagerTitleView.setText(mTabs[index]);
        simplePagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.black));
        simplePagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.colortheme));
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTabItemClickListener != null) {
                    onTabItemClickListener.onTabItemClick(index, v);
                }
            }
        });

        return simplePagerTitleView;
    }


    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setLineHeight(DisplayUtil.dip2px(context, 2));
        linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
        linePagerIndicator.setColors(ContextCompat.getColor(context, R.color.colortheme));
        return linePagerIndicator;
    }

    private OnTabItemClickListener onTabItemClickListener;

    public void setOnTabItemClickListener(OnTabItemClickListener onTabItemClickListener) {
        this.onTabItemClickListener = onTabItemClickListener;
    }

    public interface OnTabItemClickListener {
        void onTabItemClick(int position, View view);
    }
}
