package com.langt.zjgx.login.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.login.LoginView;
import com.langt.zjgx.login.model.UserLoginBean;

public class LoginPresenter extends BasePresenter<LoginView> {
    public LoginPresenter(LoginView loginView) {
        super(loginView);
    }

    public void login(String phone,String password){
        addDisposable(apiClient.userLogin(phone, password), new BaseObserver<UserLoginBean>(baseView) {
            @Override
            public void onError(String str) {

            }

            @Override
            public void onSuccess(UserLoginBean bean) {

            }
        });
    }
}
