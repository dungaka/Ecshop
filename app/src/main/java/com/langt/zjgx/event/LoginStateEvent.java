package com.langt.zjgx.event;


public class LoginStateEvent {
    private boolean isLogin;

    public LoginStateEvent(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
