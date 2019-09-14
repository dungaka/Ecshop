package com.langt.zjgx.model;

import java.io.Serializable;

public class GoodsSku implements Serializable {
    /**
     * skuId :
     * skuName1 :
     * skuValue1 :
     * skuName2 :
     * skuValue2 :
     * goodsImg : http://fdfaf
     * skuNum :
     * selectNum :标记商品数量
     * goodsCostPrice :
     * goodsCurPrice :
     */

    private String skuId;
    private String skuName1;
    private String skuValue1;
    private String skuName2;
    private String skuValue2;
    private String goodsImg;
    private int skuNum;
    private int selectNum;
    private String goodsCostPrice;
    private String goodsCurPrice;
    private String goodsOrigPrice;
    private String goodsBuyNum;
    private String skuDesc;
    private int saleNum;

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public String getSkuDesc() {
        return skuDesc;
    }

    public void setSkuDesc(String skuDesc) {
        this.skuDesc = skuDesc;
    }

    public String getGoodsBuyNum() {
        return goodsBuyNum;
    }

    public void setGoodsBuyNum(String goodsBuyNum) {
        this.goodsBuyNum = goodsBuyNum;
    }

    public String getGoodsOrigPrice() {
        return goodsOrigPrice;
    }

    public void setGoodsOrigPrice(String goodsOrigPrice) {
        this.goodsOrigPrice = goodsOrigPrice;
    }

    public int getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(int selectNum) {
        this.selectNum = selectNum;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSkuName1() {
        return skuName1;
    }

    public void setSkuName1(String skuName1) {
        this.skuName1 = skuName1;
    }

    public String getSkuValue1() {
        return skuValue1;
    }

    public void setSkuValue1(String skuValue1) {
        this.skuValue1 = skuValue1;
    }

    public String getSkuName2() {
        return skuName2;
    }

    public void setSkuName2(String skuName2) {
        this.skuName2 = skuName2;
    }

    public String getSkuValue2() {
        return skuValue2;
    }

    public void setSkuValue2(String skuValue2) {
        this.skuValue2 = skuValue2;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public int getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(int skuNum) {
        this.skuNum = skuNum;
    }

    public String getGoodsCostPrice() {
        return goodsCostPrice;
    }

    public void setGoodsCostPrice(String goodsCostPrice) {
        this.goodsCostPrice = goodsCostPrice;
    }

    public String getGoodsCurPrice() {
        return goodsCurPrice;
    }

    public void setGoodsCurPrice(String goodsCurPrice) {
        this.goodsCurPrice = goodsCurPrice;
    }
}
