package com.langt.zjgx.model;

import com.google.gson.annotations.SerializedName;

/**
 * 轮播图实体.
 * {
 * "adImg": "https://shop.zjguangxuan.com/userfiles/retailOaAd/20190620120956VAJkV4.jpg",
 * "adUrl": "49108aee36d94adb858e1e222d2c8a61",
 * "urlType": 2
 * }
 */
public class Banner {

    @SerializedName("adImg")
    private String mPicture; // 轮播图图片

    @SerializedName("description")
    private String mDesc; // 描述

    @SerializedName("adUrl")
    private String mUrl; // 外链URL
    /**
     * //0链接富文本;1店铺;2商品;3平台商品二级分类;4零售团购列表;5店铺优惠券列表;6积分换购商品列表;7零售限时商品列表;8零售满减商品列表
     */
    private int urlType;

    public String getPicture() {
        return mPicture;
    }

    public String getDesc() {
        return mDesc;
    }

    public String getUrl() {
        return mUrl;
    }

    public int getUrlType() {
        return urlType;
    }

    public void setUrlType(int urlType) {
        this.urlType = urlType;
    }

    public Banner() {
    }

    public Banner(String mPicture, String mDesc, String mUrl) {
        this.mPicture = mPicture;
        this.mDesc = mDesc;
        this.mUrl = mUrl;
    }
}
