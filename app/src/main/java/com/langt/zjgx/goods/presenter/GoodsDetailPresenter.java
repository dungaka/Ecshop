package com.langt.zjgx.goods.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.goods.view.IGoodsDetailView;
import com.langt.zjgx.model.GoodsBean;
import com.langt.zjgx.utils.LogUtils;

public class GoodsDetailPresenter extends BasePresenter<IGoodsDetailView> {
    public GoodsDetailPresenter(IGoodsDetailView iGoodsDetailView) {
        super(iGoodsDetailView);
    }

    public void test(){
        LogUtils.i("电泳方法了");
    }

    public void getGoodsDetailInfo(String shopId, String goodsId, String flag){
        addDisposable(apiClient.getGoodsDetailInfo(shopId, goodsId, flag), new BaseObserver<GoodsBean>(baseView) {
            @Override
            public void onError(String str) {

            }

            @Override
            public void onSuccess(GoodsBean bean) {

            }
        });
    }
}
