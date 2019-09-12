package com.langt.zjgx.mine;

import android.content.Intent;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;

import butterknife.OnClick;

public class AddressManagerActivity extends BaseActivity {
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_address_manager;
    }

    @Override
    public void initView() {

    }


    @OnClick(R.id.tv_add_address)
    void createAddr(){
        Intent intent = new Intent(this,NewAddrActivity.class);
        startActivity(intent);

    }
}
