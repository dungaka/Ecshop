package com.langt.zjgx.login;

import com.langt.zjgx.base.BaseView;
import com.langt.zjgx.login.model.UserLoginBean;

public interface LoginView extends BaseView {


    void onLogin(UserLoginBean bean);
}
