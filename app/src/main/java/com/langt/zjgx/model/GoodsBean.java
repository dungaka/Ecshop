package com.langt.zjgx.model;

import java.util.List;

public class GoodsBean {


    /**
     * agtstate : 0
     * goodsCurPrice : 0.20
     * goodsId : 447fbe4a35b24329aa639ea0a17a1c50
     * goodsImg : https://shop.zjguangxuan.com/userfiles/covimg/201906220945410tAhR6.jpg
     * goodsName : 8-7-法国进口红酒批发OEM贴牌定制干红葡萄酒
     * goodsSales : 0
     * goodsSku : []
     * goodsUnit : 件
     * imgList : []
     * shopDistance : 6.61km
     * shopId : 18f95757a80d4a6ba7d5f370fcc22dc8
     * shopName : 张珂玮零食店
     * shopType : 0
     * skuId : bf21319caa07469aafa4077e794cd1d6
     * zsGoodsSku : []
     */

    private int agtstate;
    private String goodsCurPrice;
    private String goodsId;
    private String goodsImg;
    private String goodsName;
    private int goodsSales;
    private String goodsUnit;
    private String shopDistance;
    private String shopId;
    private String shopName;
    private int shopType;
    private String skuId;
    private List<GoodsSku> goodsSku;
    private List<?> imgList;
    private List<?> zsGoodsSku;

    public GoodsBean(String shopName) {
    }

    public int getAgtstate() {
        return agtstate;
    }

    public void setAgtstate(int agtstate) {
        this.agtstate = agtstate;
    }

    public String getGoodsCurPrice() {
        return goodsCurPrice;
    }

    public void setGoodsCurPrice(String goodsCurPrice) {
        this.goodsCurPrice = goodsCurPrice;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(int goodsSales) {
        this.goodsSales = goodsSales;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getShopDistance() {
        return shopDistance;
    }

    public void setShopDistance(String shopDistance) {
        this.shopDistance = shopDistance;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getShopType() {
        return shopType;
    }

    public void setShopType(int shopType) {
        this.shopType = shopType;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public List<GoodsSku> getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(List<GoodsSku> goodsSku) {
        this.goodsSku = goodsSku;
    }

    public List<?> getImgList() {
        return imgList;
    }

    public void setImgList(List<?> imgList) {
        this.imgList = imgList;
    }

    public List<?> getZsGoodsSku() {
        return zsGoodsSku;
    }

    public void setZsGoodsSku(List<?> zsGoodsSku) {
        this.zsGoodsSku = zsGoodsSku;
    }
}
