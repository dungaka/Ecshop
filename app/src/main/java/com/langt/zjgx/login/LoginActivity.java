package com.langt.zjgx.login;

import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.ui.EcShopMainActivity;

import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_login;
    }

    @Override
    public void initView() {

    }


    @OnClick({R.id.btn_login,R.id.btn_register,R.id.tv_forget})
    void onButtonClick(View view){
        switch (view.getId()){
            case R.id.btn_login:
                readyGo(EcShopMainActivity.class);
                finish();
                break;
            case R.id.btn_register:
                readyGo(RegisterActivity.class);
                break;
            case R.id.tv_forget:
                break;

        }
    }


}
