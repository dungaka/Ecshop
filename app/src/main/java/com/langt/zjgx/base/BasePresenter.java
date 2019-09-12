package com.langt.zjgx.base;

import com.langt.zjgx.server.ApiRetrofit;
import com.langt.zjgx.server.ApiServer;
import com.langt.zjgx.server.HttpClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BasePresenter<V extends BaseView> {
    protected ApiServer apiServer = ApiRetrofit.getInstance().getApiServer();
    protected HttpClient apiClient = new HttpClient();
    public V baseView;
    private CompositeDisposable compositeDisposable;

    public BasePresenter(V v) {
        this.baseView = v;
    }

    public void detachView() {
        this.baseView = null;
        removeDisposable();
    }

    public V getBaseView() {
        return this.baseView;
    }

    public void addDisposable(Observable<?> observable, BaseObserver baseObserver) {
        if (this.compositeDisposable == null) {
            this.compositeDisposable = new CompositeDisposable();
        }
        this.compositeDisposable.add((Disposable) observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(baseObserver));
    }

    public void removeDisposable() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.dispose();
        }
    }
}