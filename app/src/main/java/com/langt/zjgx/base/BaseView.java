package com.langt.zjgx.base;

public interface BaseView {


    void hideLoading();


    void onErrorCode(BaseModel baseModel);


    void showError(String str);

    void showLoading();

}