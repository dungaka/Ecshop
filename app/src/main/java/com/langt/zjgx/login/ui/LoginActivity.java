package com.langt.zjgx.login.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.GlobalFun;
import com.langt.zjgx.comm.Constants;
import com.langt.zjgx.login.LoginView;
import com.langt.zjgx.login.model.UserLoginBean;
import com.langt.zjgx.login.presenter.LoginPresenter;
import com.langt.zjgx.ui.EcShopMainActivity;
import com.langt.zjgx.utils.SPStaticUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    String userPhone;
    String pwd;
    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_login;
    }

    @Override
    public void initView() {

    }


    @OnClick({R.id.btn_login,R.id.btn_register,R.id.tv_forget,R.id.iv_weixin,R.id.iv_qq})
    void onButtonClick(View view){
        switch (view.getId()){
            case R.id.btn_login:
                userPhone = etPhone.getText().toString().trim();
                pwd = etPwd.getText().toString().trim();
                if(TextUtils.isEmpty(userPhone)){
                    showError(getString(R.string.login_verify_phone));
                }else if(TextUtils.isEmpty(pwd)){
                    showError(getString(R.string.login_hint_pwd));
                }else {
                    presenter.login(userPhone,pwd);
                }
                break;
            case R.id.btn_register:
                readyGo(RegisterActivity.class);
                break;
            case R.id.tv_forget:
                readyGo(ForgetPasswordActivity.class);
                break;
            case R.id.iv_weixin:
                break;
            case R.id.iv_qq:
                break;

        }
    }



    private void saveUserInfo(UserLoginBean bean) {
        SPStaticUtils.put(Constants.USER_PHONE, userPhone);
        SPStaticUtils.put(Constants.USER_NAME, userPhone);
        SPStaticUtils.put(Constants.PASSWORD, pwd);
        SPStaticUtils.put(Constants.USER_ID, bean.getUserId());
        SPStaticUtils.put(Constants.RC_TOKEN, bean.getRcToken());
        SPStaticUtils.put(Constants.IS_LOGIN, true);
        GlobalFun.refreshLoginState();
    }

    private void saveThirdInfo(String nickName, UserLoginBean bean){
        SPStaticUtils.put(Constants.NICK_NAME, nickName);
        SPStaticUtils.put(Constants.USER_ID, bean.getUserId());
        SPStaticUtils.put(Constants.RC_TOKEN, bean.getRcToken());
        SPStaticUtils.put(Constants.IS_LOGIN, true);
        GlobalFun.refreshLoginState();
    }

    @Override
    public void onLogin(UserLoginBean bean) {
        saveUserInfo(bean);
        readyGo(EcShopMainActivity.class);
        finish();
    }
}
