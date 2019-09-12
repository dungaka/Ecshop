package com.langt.zjgx.mine.presenter;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.BaseView;
import com.langt.zjgx.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;

public class MinePresenter extends BasePresenter {
    public MinePresenter(BaseView baseView) {
        super(baseView);
    }

    public void getCityList(){

        Map<String,Object> map = new HashMap<>();
        map.put("cmd","getCityList");


        addDisposable(apiServer.method(StringUtils.toJson(map)), new BaseObserver<BaseBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.showError(str);
            }

            @Override
            public void onSuccess(BaseBean o) {
                baseView.showError(o.toString());

            }
        });;
    }
}
