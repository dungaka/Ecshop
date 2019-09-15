package com.langt.zjgx.mine.activity;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.GlobalFun;
import com.langt.zjgx.event.LoginStateEvent;
import com.langt.zjgx.mine.presenter.SettingPresenter;
import com.langt.zjgx.mine.view.SettingView;
import com.langt.zjgx.utils.DialogUtils;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity<SettingPresenter> implements SettingView {



    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.tv_cache)
    TextView tvCache;

    @Override
    protected SettingPresenter createPresenter() {
        return new SettingPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_setting;
    }

    @Override
    public void initView() {
        presenter.getNewVersion();
    }



    @OnClick({R.id.tv_loginout,R.id.tv_modfiy_pwd,R.id.rl_cache,R.id.rl_version,R.id.tv_modfiy_avatar})
    void onClick(View view){
        switch (view.getId()){
            case R.id.tv_modfiy_avatar:
                readyGo(ModifyAvatarActivity.class);
                break;
            case R.id.tv_loginout:
                loginout();
                break;
            case R.id.tv_modfiy_pwd:
                readyGo(ModifyPasswordActivity.class);
                break;
            case R.id.rl_cache:
//                loginout();
                break;
            case R.id.rl_version:
                presenter.getNewVersion();
                break;
        }
    }


    @Override
    public void onVersion(String version) {
        tvVersion.setText(version);
    }



    private void loginout(){
        AlertDialog loginDialog = DialogUtils.createDialog(this, "是否退出登录？",
                (dialog, which) -> {
                    presenter.loginout();
                }, (dialog, which) -> {
                    dialog.dismiss();
                });
        loginDialog.show();

    }

    @Override
    public void onLoginoutSucc(String result) {

        GlobalFun.logout();

        TIMManager.getInstance().logout(new TIMCallBack() {
            @Override
            public void onError(int i, String s) {
                Log.i("TAG", "onError: " + i + " : " + s);
                EventBus.getDefault().post(new LoginStateEvent(false));
//                                    ToastUtils.showShort("退出登录错误");
                finish();
            }

            @Override
            public void onSuccess() {
                EventBus.getDefault().post(new LoginStateEvent(false));
//                                    ToastUtils.showShort("退出登录成功");
                finish();
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
