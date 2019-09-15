package com.langt.zjgx.login.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.GlobalFun;
import com.langt.zjgx.comm.Constants;
import com.langt.zjgx.login.LoginView;
import com.langt.zjgx.login.model.UserLoginBean;
import com.langt.zjgx.utils.SPStaticUtils;

public class LoginPresenter extends BasePresenter<LoginView> {
    public LoginPresenter(LoginView loginView) {
        super(loginView);
    }

    public void login(String phone,String password){
        addDisposable(apiClient.userLogin(phone, password), new BaseObserver<UserLoginBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.showError(str);
            }

            @Override
            public void onSuccess(UserLoginBean bean) {

                baseView.onLogin(bean);
            }
        });
    }

    public void thirdLogin(String uid,String nickName,String userIcon){
        addDisposable(apiClient.thirdLogin(uid, nickName, userIcon), new BaseObserver<UserLoginBean>(baseView) {
            @Override
            public void onError(String str) {

            }

            @Override
            public void onSuccess(UserLoginBean o) {

            }
        });
    }


}
