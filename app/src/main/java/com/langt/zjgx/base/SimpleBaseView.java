package com.langt.zjgx.base;

public interface SimpleBaseView extends BaseView {

    void onSuccess(BaseBean bean);
    void onFail(String str);
}
