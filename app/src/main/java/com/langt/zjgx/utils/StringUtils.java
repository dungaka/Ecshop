package com.langt.zjgx.utils;

import android.util.Log;

import java.util.Map;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.text.Html;
import android.widget.TextView;

public class StringUtils {
    /**
     * 设置带drawable的文本
     * @param imgResource 图片资源
     * @param text 文本
     */
    public static void setGoodsNameWithImage(TextView textView, Context context, @DrawableRes int imgResource, String text) {
        textView.setText(Html.fromHtml("<img src='" + imgResource + "'/>" + text,
                ImageUtils.getGoodTypeImageGetterInstance(context),
                null));
    }


    public static String toJson(Map<String, Object> params) {
        String json = GsonUtils.toJson(params);
        Log.i("OkHttp", "request======>> " + json);
        return json;
    }
}
