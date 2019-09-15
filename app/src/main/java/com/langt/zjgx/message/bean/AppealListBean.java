package com.langt.zjgx.message.bean;

import com.langt.zjgx.base.BaseBean;

import java.util.List;

/**
 * 申诉列表bean
 */
public class AppealListBean extends BaseBean {
    private String totalPage;
    private List<AppealBean> appealList;

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public List<AppealBean> getAppealList() {
        return appealList;
    }

    public void setAppealList(List<AppealBean> appealList) {
        this.appealList = appealList;
    }
}
