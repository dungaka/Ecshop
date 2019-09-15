package com.langt.zjgx.message.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.message.bean.SystemMessageListBean;
import com.langt.zjgx.message.view.INoticeView;

public class NoticePresenter extends BasePresenter<INoticeView> {
    public NoticePresenter(INoticeView iNoticeView) {
        super(iNoticeView);
    }

    public void getNoticeMessageList(int nowPage) {
        addDisposable(apiClient.getSystemMsgList(nowPage), new BaseObserver<SystemMessageListBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.onGetNoticeList(null);
            }

            @Override
            public void onSuccess(SystemMessageListBean bean) {
                baseView.onGetNoticeList(bean.getMessageList());
            }
        });
    }
}
