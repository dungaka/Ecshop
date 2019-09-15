package com.langt.zjgx.model;

import com.langt.zjgx.base.BaseBean;

import java.util.List;

public class GoodsBean extends BaseBean {


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

    private int agtstate;  // 非代销0 代销1
    // 当agtstate字段为1即商品为代销商品时，判断代销商品活动状态，其余时候不体现该字段
    // 0 普通代销零售商品  1 即将参加代销限时活动的商品  2 正在参与代销限时活动的商品
    private String sellOffLimitFlag;
    //sellOffLimitFlag字段为 1 即将参加代销限时活动的商品 时体现该信息，表示代销限时活动价格
    private String goodsLimitPrice;
    //限时开始时间
    private long actStartTime;
    // 限时结束时间
    private long actEndTime;
    //团购开始时间
    private long goStartTime;
    //团购结束时间
    private long goEndTime;
    private String goodsCurPrice;
    // 折扣/抢购价对应的原价/团购原价
    private String goodsOrigPrice;
    // //拼团价
    private String goodsCostPrice;
    // 几人团
    private String tourDesc;
    // 团购完成率
    private String goRatio;

    private String goodsId;
    private String goodsImg;
    private String goodsName;
    private int goodsSales;  // 商品销量
    private String goodsUnit;
    private String shopDistance;
    // 店铺总评分  flag=2-店铺星级时   返回
    private float shopScore;
    // 商品好评率  flag=3-商品好评率时
    private String goodsScore;
    private String shopId;
    private String shopName;
    private int shopType;
    private String skuId;  // 商品规格id
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

    public String getSellOffLimitFlag() {
        return sellOffLimitFlag;
    }

    public void setSellOffLimitFlag(String sellOffLimitFlag) {
        this.sellOffLimitFlag = sellOffLimitFlag;
    }

    public String getGoodsLimitPrice() {
        return goodsLimitPrice;
    }

    public void setGoodsLimitPrice(String goodsLimitPrice) {
        this.goodsLimitPrice = goodsLimitPrice;
    }

    public long getActStartTime() {
        return actStartTime;
    }

    public void setActStartTime(long actStartTime) {
        this.actStartTime = actStartTime;
    }

    public long getActEndTime() {
        return actEndTime;
    }

    public void setActEndTime(long actEndTime) {
        this.actEndTime = actEndTime;
    }

    public long getGoStartTime() {
        return goStartTime;
    }

    public void setGoStartTime(long goStartTime) {
        this.goStartTime = goStartTime;
    }

    public long getGoEndTime() {
        return goEndTime;
    }

    public void setGoEndTime(long goEndTime) {
        this.goEndTime = goEndTime;
    }

    public String getGoodsOrigPrice() {
        return goodsOrigPrice;
    }

    public void setGoodsOrigPrice(String goodsOrigPrice) {
        this.goodsOrigPrice = goodsOrigPrice;
    }

    public String getGoodsCostPrice() {
        return goodsCostPrice;
    }

    public void setGoodsCostPrice(String goodsCostPrice) {
        this.goodsCostPrice = goodsCostPrice;
    }

    public String getTourDesc() {
        return tourDesc;
    }

    public void setTourDesc(String tourDesc) {
        this.tourDesc = tourDesc;
    }

    public String getGoRatio() {
        return goRatio;
    }

    public void setGoRatio(String goRatio) {
        this.goRatio = goRatio;
    }

    public float getShopScore() {
        return shopScore;
    }

    public void setShopScore(float shopScore) {
        this.shopScore = shopScore;
    }

    public String getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(String goodsScore) {
        this.goodsScore = goodsScore;
    }

}
