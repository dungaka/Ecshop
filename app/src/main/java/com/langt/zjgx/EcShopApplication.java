package com.langt.zjgx;

import android.app.Application;

public class EcShopApplication extends Application {

    private static EcShopApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }


    public static EcShopApplication getContext(){
        return context;
    }
}
