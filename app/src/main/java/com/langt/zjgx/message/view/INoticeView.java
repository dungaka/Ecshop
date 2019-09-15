package com.langt.zjgx.message.view;

import com.langt.zjgx.base.BaseView;
import com.langt.zjgx.message.bean.SystemMessageBean;

import java.util.List;

public interface INoticeView extends BaseView {
    void onGetNoticeList(List<SystemMessageBean> messageBeanList);
}
