package com.langt.zjgx.message.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.message.bean.UnReadMessageCountBean;
import com.langt.zjgx.message.view.IMessageActivityView;

public class MessageActivityPresenter extends BasePresenter<IMessageActivityView> {
    public MessageActivityPresenter(IMessageActivityView iMessageActivityView) {
        super(iMessageActivityView);
    }
    public void getMessageUnReadCount(){
        addDisposable(apiClient.getMessageUnReadCount(), new BaseObserver<UnReadMessageCountBean>(baseView) {
            @Override
            public void onError(String str) {
            }

            @Override
            public void onSuccess(UnReadMessageCountBean bean) {
            }
        });
    }
}
