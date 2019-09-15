package com.langt.zjgx.message.bean;

import com.langt.zjgx.base.BaseBean;

/**
 * 申诉详情bean
 */
public class AppealDetailBean extends BaseBean {
    private AppealBean appealDetail;

    public AppealBean getAppealDetail() {
        return appealDetail;
    }

    public void setAppealDetail(AppealBean appealDetail) {
        this.appealDetail = appealDetail;
    }
}
