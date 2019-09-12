package com.langt.zjgx.utils.carsh;

/**
 * Created by zhangzheng on 2017/4/5.
 */

public interface OnExceptionCallBack {

    void onThrowException(Thread t, Throwable e, IHandlerException handler);
}
