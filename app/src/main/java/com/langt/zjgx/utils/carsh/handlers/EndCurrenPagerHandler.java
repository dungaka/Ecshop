package com.langt.zjgx.utils.carsh.handlers;

import android.app.Activity;

import com.langt.zjgx.utils.carsh.IHandlerException;
import com.langt.zjgx.utils.carsh.WindowManagerGlobal;


/**
 * Created by zhangzheng on 2017/4/5.
 */

public class EndCurrenPagerHandler implements IHandlerException {
    @Override
    public boolean handler(Throwable e) {
        Activity currenActivity = WindowManagerGlobal.getInstance().getCurrenActivity();
        if (currenActivity != null) {
            currenActivity.finish();
        }
        return false;
    }
}
