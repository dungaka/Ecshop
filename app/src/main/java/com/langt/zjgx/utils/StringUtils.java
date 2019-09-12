package com.langt.zjgx.utils;

import android.util.Log;

import java.util.Map;

public class StringUtils {


    public static String toJson(Map<String, Object> params) {
        String json = GsonUtils.toJson(params);
        Log.i("OkHttp", "request======>> " + json);
        return json;
    }
}
