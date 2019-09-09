package com.langt.zjgx.home.model;

public class GoodsBean {
    private String shopName;
    private String goodsInfo;
    private String goodsPrice;
    private String sellNum;
    private String distance;


    public GoodsBean(String shopName, String goodsInfo, String goodsPrice, String sellNum, String distance) {
        this.shopName = shopName;
        this.goodsInfo = goodsInfo;
        this.goodsPrice = goodsPrice;
        this.sellNum = sellNum;
        this.distance = distance;
    }

    public GoodsBean(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getSellNum() {
        return sellNum;
    }

    public void setSellNum(String sellNum) {
        this.sellNum = sellNum;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
