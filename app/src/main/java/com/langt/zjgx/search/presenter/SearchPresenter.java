package com.langt.zjgx.search.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.search.model.HotSearchListResultModel;
import com.langt.zjgx.search.view.ISearchView;

public class SearchPresenter extends BasePresenter<ISearchView> {
    public SearchPresenter(ISearchView iSearchView) {
        super(iSearchView);
    }

    /**
     * 获取热门搜索列表
     */
    public void getHostSearchList() {
        addDisposable(apiClient.getHotSearchList(), new BaseObserver<HotSearchListResultModel>(baseView) {
            @Override
            public void onError(String str) {

            }

            @Override
            public void onSuccess(HotSearchListResultModel bean) {
                baseView.onGetHotSearchList(bean.getSearchKeyList());
            }
        });
    }
}
