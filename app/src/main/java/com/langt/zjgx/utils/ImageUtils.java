package com.langt.zjgx.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;

import com.chaychan.library.UIUtils;

public class ImageUtils {
    /**
     * 获取商品名称前面展示商品类型的图片
     */
    public static Html.ImageGetter getGoodTypeImageGetterInstance(final Context context) {
        Html.ImageGetter imgGetter = new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                int id = Integer.parseInt(source);
                Drawable d = context.getResources().getDrawable(id);
                int wdp = UIUtils.dip2Px(context, 40);
                int hdp = UIUtils.dip2Px(context, 20);
                d.setBounds(0, 0, wdp, hdp);
                return d;
            }
        };
        return imgGetter;
    }
}
