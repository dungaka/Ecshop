package com.langt.zjgx.utils.carsh.handlers;


import com.langt.zjgx.utils.carsh.IHandlerException;

/**
 * Created by zhangzheng on 2017/4/5.
 */

public class IgnoreHandler implements IHandlerException {
    @Override
    public boolean handler(Throwable e) {
        return false;
    }
}
