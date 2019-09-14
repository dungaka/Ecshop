package com.langt.zjgx.home.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.view.IHomeRecommendGoodsView;
import com.langt.zjgx.model.HomeRecommendGoodsBean;

public class HomeRecommendGoodsListPresenter extends BasePresenter<IHomeRecommendGoodsView> {
    public HomeRecommendGoodsListPresenter(IHomeRecommendGoodsView iHomeRecommendGoodsView) {
        super(iHomeRecommendGoodsView);
    }

    public void getHomeRecommendGoodsList(String flag, int nowPage) {
        addDisposable(apiClient.getHomeRecommendGoodsList(flag, nowPage), new BaseObserver<HomeRecommendGoodsBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.hideLoading();
                baseView.onGetGoodsList(null);
            }

            @Override
            public void onSuccess(HomeRecommendGoodsBean bean) {
                baseView.hideLoading();
                baseView.onGetGoodsList(bean.getGoodsList());
            }
        });
    }
}
