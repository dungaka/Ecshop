package com.langt.zjgx.login.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.SimpleBaseView;
import com.langt.zjgx.login.presenter.RegisterPresenter;
import com.langt.zjgx.utils.RegularUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements SimpleBaseView {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.et_pwd_sure)
    EditText etPwdSure;
    @BindView(R.id.et_smscode)
    EditText etCode;
    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this,this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_register;
    }

    @Override
    public void initView() {

    }


    @OnClick({R.id.tv_sendcode,R.id.btn_register})
    void onButtonClick(View view){
        switch (view.getId()){
            case R.id.tv_sendcode:
                String phone = etPhone.getText().toString().trim();
                if(RegularUtils.isMobileSimple(phone)) {
                    presenter.sendSmsCode(phone,"0");
                }else{
                    showError(getString(R.string.login_verify_phone));
                }
                break;
            case R.id.btn_register:
                String moblie = etPhone.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                String pwd2 = etPwdSure.getText().toString().trim();
                String code = etCode.getText().toString().trim();
                if(!RegularUtils.isMobileSimple(moblie)){
                    showError(getString(R.string.login_verify_phone));
                }else if(TextUtils.isEmpty(pwd)||TextUtils.isEmpty(pwd2)){
                    showError(getString(R.string.register_pwd_not_null));
                }else if(!TextUtils.equals(pwd,pwd2)){
                    showError(getString(R.string.register_pwd_equals));
                }else if(TextUtils.isEmpty(code)){
                    showError(getString(R.string.login_hint_smscode));
                }else {
                    presenter.register(moblie,pwd,code);
                }

                break;
        }

    }

    @Override
    public void onSuccess(BaseBean bean) {
            finish();
    }

    @Override
    public void onFail(String str) {

    }
}
