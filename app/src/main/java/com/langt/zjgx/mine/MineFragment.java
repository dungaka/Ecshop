package com.langt.zjgx.mine;

import android.os.Bundle;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;

public class MineFragment extends BaseFragment {
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_mine;
    }

    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
