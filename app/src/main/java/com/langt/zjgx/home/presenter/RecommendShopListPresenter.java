package com.langt.zjgx.home.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.view.IRecommendShopListView;
import com.langt.zjgx.model.ShopListResultBean;

/**
 * 推荐好店列表presenter
 */
public class RecommendShopListPresenter extends BasePresenter<IRecommendShopListView> {
    public RecommendShopListPresenter(IRecommendShopListView iRecommendShopListView) {
        super(iRecommendShopListView);
    }

    public void getShopList(String key, int nowPage) {
        addDisposable(apiClient.searchNearShopList("", key, nowPage), new BaseObserver<ShopListResultBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.hideLoading();
            }

            @Override
            public void onSuccess(ShopListResultBean bean) {
                baseView.hideLoading();
                baseView.onGetShopList(bean.getShopList());
            }
        });
    }
}
