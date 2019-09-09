package com.langt.zjgx.login;

import android.content.Intent;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.ui.EcShopMainActivity;

public class SplashActivity extends BaseActivity {
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        startActivity(new Intent(this, EcShopMainActivity.class));
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }
}
