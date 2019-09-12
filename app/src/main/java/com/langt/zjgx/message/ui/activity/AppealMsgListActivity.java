package com.langt.zjgx.message.ui.activity;

import android.support.v4.app.Fragment;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public class AppealMsgListActivity extends BaseActivity {



    private String[] mTitles = new String[]{"待处理", "已处理"};
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_appeal;
    }

    @Override
    public void initView() {

    }
}
