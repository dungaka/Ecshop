package com.langt.zjgx.shop;

import android.widget.TextView;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;

import butterknife.BindView;

/**
 * 店铺基本信息页面
 */
public class ShopBaseInfoActivity extends BaseActivity {
    @BindView(R.id.tv_shop_name)
    TextView tv_shop_name;
    @BindView(R.id.tv_shop_business_time)
    TextView tv_shop_business_time;
    @BindView(R.id.tv_shop_address)
    TextView tv_shop_address;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_base_info;
    }

    @Override
    public void initView() {
        tv_shop_name.setText("小小酒馆");
        tv_shop_business_time.setText("24小时营业");
        tv_shop_address.setText("管城区紫荆山路商城路裕鸿国际");
    }
}
