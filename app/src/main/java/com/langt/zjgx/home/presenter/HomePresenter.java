package com.langt.zjgx.home.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.view.IHomeView;
import com.langt.zjgx.model.HomePageBean;

public class HomePresenter extends BasePresenter<IHomeView> {
    public HomePresenter(IHomeView iHomeView) {
        super(iHomeView);
    }

    public void getHomePageInfo() {
        baseView.showLoading();
        addDisposable(apiClient.getHomePageInfo(), new BaseObserver<HomePageBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.hideLoading();
            }

            @Override
            public void onSuccess(HomePageBean bean) {
                baseView.hideLoading();
                baseView.onGetHomePageInfo(bean);
            }
        });
    }
}
