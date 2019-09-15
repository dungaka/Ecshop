package com.langt.zjgx.utils;


import android.content.Context;

import com.bumptech.glide.request.RequestOptions;


/**
 * Created by Administrator on 2019/2/20.
 */

public class OptionsUtils {


    public static RequestOptions defaultOptions(){
        RequestOptions options = new RequestOptions()
                //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的宽高都大于等于ImageView的宽度，然后截取中间的显示。）
                .centerCrop();
//                .error(R.mipmap.default_img)
//                .placeholder(R.mipmap.default_img);
        return options;
    }

    public static RequestOptions circleCrop(){
        RequestOptions options = new RequestOptions()
                //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                .fitCenter()
//                .error(R.mipmap.default_circle)
//                .placeholder(R.mipmap.default_circle)
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的宽高都大于等于ImageView的宽度，然后截取中间的显示。）
                .centerCrop()
//                .transform(new GlideRoundTransform(mContent, 10));
                .circleCrop();//指定图片的缩放类型为centerCrop （圆形）
        return options;
    }

    public static RequestOptions transform(Context content, int dp){
        RequestOptions options = new RequestOptions()
                //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                .fitCenter()
//                .error(R.mipmap.default_round)
//                .placeholder(R.mipmap.default_round)
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的宽高都大于等于ImageView的宽度，然后截取中间的显示。）
                .centerCrop()
                .transform(new GlideRoundTransform(content, dp));
        return options;
    }


}

