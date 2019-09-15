package com.langt.zjgx.message.presenter;

import com.langt.zjgx.base.BaseBean;
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

    /**
     * 删除消息
     * @param messageIds 消息id，多个用，隔开
     */
    public void delNoticeMessage(String messageIds){
        addDisposable(apiClient.delSystemMsgList(messageIds), new BaseObserver<BaseBean>(baseView) {
            @Override
            public void onError(String str) {

            }

            @Override
            public void onSuccess(BaseBean bean) {

            }
        });
    }
}
