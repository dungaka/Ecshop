package com.langt.zjgx.mine.presenter;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.GlobalFun;
import com.langt.zjgx.mine.model.VersionBean;
import com.langt.zjgx.mine.view.SettingView;

import io.reactivex.Observable;

public class SettingPresenter extends BasePresenter<SettingView> {
    public SettingPresenter(SettingView simpleBaseView) {
        super(simpleBaseView);
    }

    public void getNewVersion(){
        Observable<VersionBean> observable = apiClient.getVersion(GlobalFun.getUserId());
        addDisposable(observable, new BaseObserver<VersionBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.showError(str);
            }

            @Override
            public void onSuccess(VersionBean bean) {
                baseView.onVersion(bean.getDescc());
            }
        });
    }

    public void loginout(){

        Observable<BaseBean> observable = apiClient.loginout(GlobalFun.getUserId());
        addDisposable(observable, new BaseObserver(baseView) {
            @Override
            public void onError(String str) {
                baseView.showError(str);
            }

            @Override
            public void onSuccess(Object o) {
                baseView.onLoginoutSucc("");
            }
        });

    }
}
