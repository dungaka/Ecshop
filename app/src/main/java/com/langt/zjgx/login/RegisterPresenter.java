package com.langt.zjgx.login;

import android.content.Context;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.SimpleBaseView;

import io.reactivex.Observable;

public class RegisterPresenter extends BasePresenter<SimpleBaseView> {
    Context context;
    public RegisterPresenter(Context context, SimpleBaseView baseView) {
        super(baseView);
        this.context = context;
    }

    public void sendSmsCode(String phone){
        Observable<BaseBean> observable = apiClient.sendSmsCode(phone, "0");
        addDisposable(observable, new BaseObserver<BaseBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.showError(str);
            }

            @Override
            public void onSuccess(BaseBean o) {
                if(o.isSuccess()){
                    baseView.showError(context.getResources().getString(R.string.login_sms_receive));
                }
            }
        });
    }

    public void register(String phone,String pwd,String code){
        Observable<BaseBean> observable = apiClient.userRegister(phone, pwd, code);
        addDisposable(observable, new BaseObserver<BaseBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.showError(str);
            }

            @Override
            public void onSuccess(BaseBean bean) {
                if (bean.isSuccess()){
                    baseView.showError(context.getResources().getString(R.string.register_success));
                    baseView.onSuccess();
                }
            }
        });
    }
}
