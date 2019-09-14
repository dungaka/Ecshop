package com.langt.zjgx.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtils {
    public static void loadImage(Context context, String url, ImageView target) {
        Glide.with(context)
                .load(url)
                .into(target);
    }

    public static void loadImage(Fragment fragment, String url, ImageView target) {
        Glide.with(fragment)
                .load(url)
                .into(target);
    }
}
