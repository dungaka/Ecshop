package com.langt.zjgx.mine.presenter;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.BaseView;
import com.langt.zjgx.base.GlobalFun;
import com.langt.zjgx.mine.model.MyCollectListBean;

import io.reactivex.Observable;

public class CollectListPresenter extends BasePresenter {

    public CollectListPresenter(BaseView baseView) {
        super(baseView);
    }

    public void getMyCollectList(int type, int page){
        Observable<MyCollectListBean> observable = apiClient.getMyCollectList(GlobalFun.getUserId(), type, page);

        addDisposable(observable, new BaseObserver<BaseBean>(baseView) {
            @Override
            public void onError(String str) {

            }

            @Override
            public void onSuccess(BaseBean o) {


            }
        });
    }
}
