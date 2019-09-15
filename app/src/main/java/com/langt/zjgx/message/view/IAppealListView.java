package com.langt.zjgx.message.view;

import com.langt.zjgx.base.BaseView;
import com.langt.zjgx.message.bean.AppealBean;

import java.util.List;

public interface IAppealListView extends BaseView {
    void onGetAppealList(List<AppealBean> appealBeanList);
}
