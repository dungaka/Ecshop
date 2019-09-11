package com.langt.zjgx.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.adapter.FullReductionZhuanChangAdapter;
import com.langt.zjgx.home.model.ShopBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 满减专场页面
 */
public class FullReductionZhuanChangActivity extends BaseActivity {
    @BindView(R.id.et_searchView)
    EditText et_searchView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<ShopBean> itemList;
    private FullReductionZhuanChangAdapter adapter;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_full_reduction_zhuanchang;
    }

    @Override
    public void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList = new ArrayList<>();
        adapter = new FullReductionZhuanChangAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initData() {
        for (int i = 0; i < 3; i++) {
            itemList.add(new ShopBean());
        }
        adapter.notifyDataSetChanged();
    }
}
