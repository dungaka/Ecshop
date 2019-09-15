package com.langt.zjgx.mine.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.SimpleBaseView;
import com.langt.zjgx.comm.Constants;
import com.langt.zjgx.event.LoginStateEvent;
import com.langt.zjgx.login.model.MineInfoBean;
import com.langt.zjgx.message.ui.activity.MessageActivity;
import com.langt.zjgx.mine.activity.AddressManagerActivity;
import com.langt.zjgx.mine.activity.MyCollectionActivity;
import com.langt.zjgx.mine.activity.MyFootprintActivity;
import com.langt.zjgx.mine.activity.MyOrderActivity;
import com.langt.zjgx.mine.activity.SettingActivity;
import com.langt.zjgx.mine.activity.ShareActivity;
import com.langt.zjgx.mine.presenter.MinePresenter;
import com.langt.zjgx.utils.OptionsUtils;
import com.langt.zjgx.utils.SPStaticUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends BaseFragment<MinePresenter> implements SimpleBaseView {


    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;


    MineInfoBean mineInfoBean;
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


    @Override
    public void initView(View view) {
        super.initView(view);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        presenter.getMineInfo();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginStateChange(LoginStateEvent event) {
        presenter.getMineInfo();
    }

    @OnClick({R.id.fl_collect, R.id.fl_footprint, R.id.fl_address, R.id.fl_apply, R.id.fl_custom, R.id.fl_share,
            R.id.text_order_all, R.id.fl_order_dfk,R.id.fl_order_dpj,R.id.fl_order_ptz,R.id.fl_order_tksh,
            R.id.fl_order_yfh,R.id.iv_message,R.id.iv_avatar,R.id.tv_name})
    void onFlClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.iv_avatar:
            case R.id.tv_name:
                readyGo(SettingActivity.class);
                break;
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
                presenter.getMineInfo();
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

    @Override
    public void onSuccess(BaseBean bean) {

        if(bean instanceof MineInfoBean){
            this.mineInfoBean = (MineInfoBean) bean;
        }
        if(mineInfoBean!=null){
            SPStaticUtils.put(Constants.USER_ICON, mineInfoBean.getUserIcon());
            SPStaticUtils.put(Constants.NICK_NAME, mineInfoBean.getNickName());
            tvName.setText(mineInfoBean.getNickName());
            Glide.with(this).load(mineInfoBean.getUserIcon()).apply(OptionsUtils.circleCrop()).into(ivAvatar);
        }



    }

    @Override
    public void onFail(String str) {

    }


    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();

    }
}
