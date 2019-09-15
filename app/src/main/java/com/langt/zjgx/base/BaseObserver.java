package com.langt.zjgx.base;

import com.google.gson.JsonParseException;
import com.langt.zjgx.utils.LogUtils;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

public abstract class BaseObserver<T> extends DisposableObserver<T> {
    public static final int BAD_NETWORK = 1002;
    public static final int CONNECT_ERROR = 1003;
    public static final int CONNECT_TIMEOUT = 1004;
    public static final int PARSE_ERROR = 1001;
    protected BaseView view;

    public void onComplete() {
    }

    public abstract void onError(String str);

    protected void onStart() {
    }

    public abstract void onSuccess(T t);

    public BaseObserver(BaseView baseView) {
        this.view = baseView;
    }

    public void onNext(T t) {
        try {
            BaseBean baseModel = (BaseBean) t;
            if (baseModel.isSuccess()) {
                onSuccess(t);
            } else if (this.view != null) {
                onError(baseModel.getResultNote());
                this.view.onErrorCode(baseModel);
            }
        } catch (Throwable t2) {
            t2.printStackTrace();
            onError(t2.toString());
        }
    }

    public void onError(Throwable th) {
        th.printStackTrace();
        LogUtils.i("onError: "+th);
        if (th instanceof HttpException) {
            onException(BAD_NETWORK);
            return;
        }
        if (!(th instanceof ConnectException)) {
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof InterruptedIOException) {
                    onException(CONNECT_TIMEOUT);
                    return;
                }
                if (!((th instanceof JsonParseException) || (th instanceof JSONException))) {
                    if (!(th instanceof ParseException)) {
                        if (th != null) {
                            onError(th.toString());
                            return;
                        } else {
                            onError("未知错误");
                            return;
                        }
                    }
                }
                onException(PARSE_ERROR);
                return;
            }
        }
        onException(CONNECT_ERROR);
    }

    private void onException(int i) {
        switch (i) {
            case PARSE_ERROR:
                onError("解析数据失败");
                return;
            case BAD_NETWORK:
                onError("网络问题");
                return;
            case CONNECT_ERROR:
                onError("连接错误");
                return;
            case CONNECT_TIMEOUT:
                onError("连接超时");
                return;
            default:
                return;
        }
    }
}