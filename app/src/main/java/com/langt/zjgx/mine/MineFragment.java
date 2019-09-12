package com.langt.zjgx.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.message.ui.activity.MessageActivity;
import com.langt.zjgx.mine.presenter.MinePresenter;

import butterknife.OnClick;

public class MineFragment extends BaseFragment<MinePresenter> {


    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter(this);
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
            R.id.text_order_all, R.id.fl_order_dfk,R.id.fl_order_dpj,R.id.fl_order_ptz,R.id.fl_order_tksh,
            R.id.fl_order_yfh,R.id.iv_message})
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
                presenter.getCityList();
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
                intent = new Intent(getActivity(), MyOrderActivity.class);
                intent.putExtra("index",1);
                startActivity(intent);
                break;
            case R.id.fl_order_dpj:
                intent = new Intent(getActivity(), MyOrderActivity.class);
                intent.putExtra("index",4);
                startActivity(intent);
                break;
            case R.id.fl_order_ptz:
                intent = new Intent(getActivity(), MyOrderActivity.class);
                intent.putExtra("index",2);
                startActivity(intent);
                break;
            case R.id.fl_order_yfh:
                intent = new Intent(getActivity(), MyOrderActivity.class);
                intent.putExtra("index",3);
                startActivity(intent);
                break;
            case R.id.fl_order_tksh:
                intent = new Intent(getActivity(), MyOrderActivity.class);
                intent.putExtra("index",5);
                startActivity(intent);
                break;
            case R.id.iv_message:
                intent = new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
                break;

        }
    }
}
