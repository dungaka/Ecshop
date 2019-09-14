package com.langt.zjgx.search.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.langt.zjgx.R;
import com.langt.zjgx.widget.flowlayout.FlowLayout;
import com.langt.zjgx.widget.flowlayout.TagAdapter;

import java.util.List;

/**
 * 搜多頁面熱門搜索
 */
public class MySearchHotKeyAdapter extends TagAdapter<String> {
    private ViewGroup parentView;
    private Context context;

    public MySearchHotKeyAdapter(Context context, ViewGroup parentView, List<String> datas) {
        super(datas);
        this.parentView = parentView;
        this.context = context;
    }

    @Override
    public View getView(FlowLayout parent, int position, String item) {
        TextView tv = (TextView) LayoutInflater.from(context)
                .inflate(R.layout.tag_flow_view, parentView, false);
        tv.setText(item);
        return tv;
    }
}
