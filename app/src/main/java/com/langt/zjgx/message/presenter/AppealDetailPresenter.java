package com.langt.zjgx.message.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.message.bean.AppealDetailBean;
import com.langt.zjgx.message.view.IAppealDetailView;

public class AppealDetailPresenter extends BasePresenter<IAppealDetailView> {
    public AppealDetailPresenter(IAppealDetailView iAppealDetailView) {
        super(iAppealDetailView);
    }

    /**
     * 获取申诉详情
     *
     * @param appealId 申诉id
     */
    public void getAppealDetail(String appealId) {
        baseView.showLoading();
        addDisposable(apiClient.getAppealMsgDetail(appealId), new BaseObserver<AppealDetailBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.onGetAppealDetail(null);
            }

            @Override
            public void onSuccess(AppealDetailBean bean) {
                baseView.onGetAppealDetail(bean.getAppealDetail());
            }
        });
    }
}
