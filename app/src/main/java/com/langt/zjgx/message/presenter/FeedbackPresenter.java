package com.langt.zjgx.message.presenter;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.message.view.IFeedbackView;

/**
 * 意见反馈presenter
 */
public class FeedbackPresenter extends BasePresenter<IFeedbackView> {
    public FeedbackPresenter(IFeedbackView iFeedbackView) {
        super(iFeedbackView);
    }

    public void submitFeedback(String fdTitle,String fdContent){
        addDisposable(apiClient.feedBack(fdTitle, fdContent), new BaseObserver<BaseBean>(baseView) {
            @Override
            public void onError(String str) {

            }

            @Override
            public void onSuccess(BaseBean bean) {
                baseView.showError(bean.getResultNote());
                baseView.onFeedbackSuccess();
            }
        });
    }
}
