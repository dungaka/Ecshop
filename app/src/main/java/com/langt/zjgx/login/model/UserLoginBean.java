package com.langt.zjgx.login.model;

import com.langt.zjgx.base.BaseBean;


public class UserLoginBean extends BaseBean {

    private String userId;
    private String rcToken;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRcToken() {
        return rcToken;
    }

    public void setRcToken(String rcToken) {
        this.rcToken = rcToken;
    }
}
