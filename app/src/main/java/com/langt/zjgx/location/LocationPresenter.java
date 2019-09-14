package com.langt.zjgx.location;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.location.bean.CityIdBean;
import com.langt.zjgx.location.view.ILocationView;
import com.langt.zjgx.utils.CoreLib;

public class LocationPresenter extends BasePresenter<ILocationView> {
    public LocationPresenter(ILocationView iLocationView) {
        super(iLocationView);
    }

    public void getCurrentCityId(String province, String city) {
        addDisposable(apiClient.getLocationCity(province, city), new BaseObserver<CityIdBean>(baseView) {
            @Override
            public void onError(String str) {

            }

            @Override
            public void onSuccess(CityIdBean bean) {
                CoreLib.setCityId(bean.getCityId());
            }
        });
    }
}
