package com.langt.zjgx.login.ui;

import android.content.Intent;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.GlobalFun;
import com.langt.zjgx.login.ui.LoginActivity;
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
        if (GlobalFun.isLogin()) {
            startActivity(new Intent(this, EcShopMainActivity.class));
            finish();
        }else {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

    }

}
