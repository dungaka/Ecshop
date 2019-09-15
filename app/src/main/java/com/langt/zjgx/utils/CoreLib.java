package com.langt.zjgx.utils;

import com.langt.zjgx.base.Constant;
import com.langt.zjgx.comm.Constants;

public class CoreLib {
    public static String getUserId() {
        return SPStaticUtils.getString(Constants.USER_ID);
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

    public static void setCityId(String cityId) {
        SPStaticUtils.put(Constant.SpConstant.KEY_CITY_ID, cityId);
    }


}
