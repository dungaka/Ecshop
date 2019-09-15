package com.langt.zjgx.message.bean;

import com.langt.zjgx.base.BaseBean;

/**
 * 未读消息个数bean
 */
public class UnReadMessageCountBean extends BaseBean {
    //0未读消息（这里仅提示未读消息状态有则返回数据0 ; 没有返回空）
    private String state;
    //未读消息数量
    private String count;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
