package com.langt.zjgx.utils;

import com.langt.zjgx.base.Constant;

public class CoreLib {
    public static String getUserId() {
        return SPStaticUtils.getString(Constant.SpConstant.KEY_USER_ID);
    }

    public static String getCityId() {
//        return SPStaticUtils.getString(Constant.SpConstant.KEY_CITY_ID);
        return "155";
    }

    public static String getLongitude() {
//        return SPStaticUtils.getString(Constant.SpConstant.KEY_LONGITUDE);
        return "113.6401";
    }

    public static String getLatitude() {
//        return SPStaticUtils.getString(Constant.SpConstant.KEY_LATITUDE);
        return "34.72468";
    }


}
