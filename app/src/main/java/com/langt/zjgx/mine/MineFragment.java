package com.langt.zjgx.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

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


    @OnClick({R.id.fl_collect, R.id.fl_footprint, R.id.fl_address, R.id.fl_apply, R.id.fl_custom, R.id.fl_share,
            R.id.text_order_all, R.id.fl_order_dfk,R.id.fl_order_dpj,R.id.fl_order_ptz,R.id.fl_order_tksh,R.id.fl_order_yfh})
    void onFlClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.fl_collect:
                intent = new Intent(getActivity(), MyCollectionActivity.class);
                startActivity(intent);
                break;
            case R.id.fl_footprint:
                intent = new Intent(getActivity(), MyFootprintActivity.class);
                startActivity(intent);
                break;
            case R.id.fl_address:
                intent = new Intent(getActivity(), AddressManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.fl_apply:
                intent = new Intent(getActivity(), AddressManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.fl_custom:
                intent = new Intent(getActivity(), AddressManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.fl_share:
                intent = new Intent(getActivity(), ShareActivity.class);
                startActivity(intent);
                break;
            case R.id.text_order_all:
                intent = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.fl_order_dfk:
            case R.id.fl_order_dpj:
            case R.id.fl_order_ptz:
            case R.id.fl_order_yfh:
            case R.id.fl_order_tksh:
                intent = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intent);
                break;

        }
    }
}
