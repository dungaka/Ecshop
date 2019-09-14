package com.langt.zjgx.order;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.adapter.DiscountCouponListItemAdapter;
import com.langt.zjgx.model.DiscountCouponBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 选择优惠券页面
 */
public class ChooseDiscountCouponActivity extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<DiscountCouponBean> itemList;
    private DiscountCouponListItemAdapter adapter;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_choose_discount_coupon;
    }

    @Override
    public void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList = new ArrayList<>();
        adapter = new DiscountCouponListItemAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initData() {
        super.initData();
        for (int i = 0; i < 3; i++) {
            itemList.add(new DiscountCouponBean());
        }
        adapter.notifyDataSetChanged();
    }

    @OnClick({R.id.tv_not_use})
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.tv_not_use:
                break;
        }
    }
}
