package com.langt.zjgx.mine.presenter;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.BaseView;
import com.langt.zjgx.base.GlobalFun;
import com.langt.zjgx.base.SimpleBaseView;
import com.langt.zjgx.login.model.MineInfoBean;
import com.langt.zjgx.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class MinePresenter extends BasePresenter<SimpleBaseView> {
    public MinePresenter(SimpleBaseView baseView) {
        super(baseView);
    }

    public void getMineInfo(){
        Observable<MineInfoBean> observable = apiClient.getMineInfo(GlobalFun.getUserId());
        addDisposable(observable, new BaseObserver<MineInfoBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.showError(str);
            }

            @Override
            public void onSuccess(MineInfoBean bean) {
                baseView.onSuccess(bean);
            }
        });

    }
}
