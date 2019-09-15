package com.langt.zjgx.message.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.message.bean.AppealListBean;
import com.langt.zjgx.message.view.IAppealListView;

public class AppealListPresenter extends BasePresenter<IAppealListView> {
    public AppealListPresenter(IAppealListView iAppealListView) {
        super(iAppealListView);
    }

    /**
     * 获取申诉列表
     *
     * @param state   //0-待处理 1-已处理
     * @param nowPage 当前页码
     */
    public void getAppealList(String state, int nowPage) {
        baseView.showLoading();
        addDisposable(apiClient.getAppealMsgList(state, nowPage), new BaseObserver<AppealListBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.onGetAppealList(null);
            }

            @Override
            public void onSuccess(AppealListBean bean) {
                baseView.onGetAppealList(bean.getAppealList());
            }
        });
    }
}
