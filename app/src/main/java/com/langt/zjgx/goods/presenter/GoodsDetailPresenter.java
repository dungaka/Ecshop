package com.langt.zjgx.goods.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.goods.view.IGoodsDetailView;
import com.langt.zjgx.model.GoodsBean;
import com.langt.zjgx.utils.CoreLib;

import io.reactivex.Observable;

public class GoodsDetailPresenter extends BasePresenter<IGoodsDetailView> {
    public GoodsDetailPresenter(IGoodsDetailView iGoodsDetailView) {
        super(iGoodsDetailView);
    }

    public void getGoodsDetailInfo(String shopId, String goodsId, int flag) {
        Observable<GoodsBean> observable = apiClient.getGoodsDetailInfo(shopId, goodsId, String.valueOf(flag));
        switch (flag) {
            case Constant.ShopRecommendGoodsType.type_0: // 普通零售
                observable = apiClient.getCsGoodsDetail(shopId, CoreLib.getLatitude(), CoreLib.getLongitude());
                break;
            case Constant.ShopRecommendGoodsType.type_1: // 零售团购
                observable = apiClient.getGoGoodsDetail(goodsId);
                break;
            case Constant.ShopRecommendGoodsType.type_2:  // 零售满减商品
                observable = apiClient.getFullSubGoodsDetail(goodsId);
                break;
            case Constant.ShopRecommendGoodsType.type_3: // 零售限时抢购
                observable = apiClient.getDisctGoodsDetail(goodsId);
                break;
            case Constant.ShopRecommendGoodsType.type_4: // 厂家直销
                break;
            case Constant.ShopRecommendGoodsType.type_5: // 发起拼团商品
                observable = apiClient.getDisctGoodsDetail(goodsId);
                break;
        }


        addDisposable(observable, new BaseObserver<GoodsBean>(baseView) {
            @Override
            public void onError(String str) {

            }

            @Override
            public void onSuccess(GoodsBean bean) {

            }
        });
    }
}
