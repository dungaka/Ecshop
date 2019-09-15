package com.langt.zjgx.message.bean;

import com.langt.zjgx.base.BaseBean;

import java.util.List;

/**
 * 消息-通知列表bean
 */
public class SystemMessageListBean extends BaseBean {
    private List<SystemMessageBean> messageList;

    public List<SystemMessageBean> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<SystemMessageBean> messageList) {
        this.messageList = messageList;
    }
}
