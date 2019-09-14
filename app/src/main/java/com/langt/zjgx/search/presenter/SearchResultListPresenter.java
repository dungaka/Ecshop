package com.langt.zjgx.search.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.goods.bean.MyGoodsListBean;
import com.langt.zjgx.search.view.ISearchRersultListView;

/**
 * 搜索结果页面presenter
 */
public class SearchResultListPresenter extends BasePresenter<ISearchRersultListView> {
    public SearchResultListPresenter(ISearchRersultListView iSearchRersultListView) {
        super(iSearchRersultListView);
    }

    /**
     * 根据关键字搜索商品列表
     *
     * @param key 关键字
     */
    public void searchGoodsList(String key, int nowPage) {
        addDisposable(apiClient.searchGoodsList(key, nowPage), new BaseObserver<MyGoodsListBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.hideLoading();
            }

            @Override
            public void onSuccess(MyGoodsListBean bean) {
                baseView.hideLoading();
                baseView.onGetGoodsList(bean.getGoodsList());
            }
        });
    }
}
