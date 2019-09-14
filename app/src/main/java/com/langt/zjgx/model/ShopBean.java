package com.langt.zjgx.model;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺bean
 */
public class ShopBean implements Serializable {
    /**
     * couponBeans : []
     * freeCouponList : []
     * goodsId : 8d1e1bbfbbe2432bb7e2dc450d3fcbe6
     * goodsList : []
     * goodsName : 可可西里香鼬面包拼团
     * goodsSign : https://shop.zjguangxuan.com/userfiles/sign/jifen.png
     * goodsUnit : 袋
     * minPrice : 9.90
     * pnum : 2人团
     * shopAddr : 河南省郑州市管城区耿庄花园南苑
     * shopDesc : 服装店欢迎选购
     * shopDistance : 4.71km
     * shopId : 33ed08b793384c24af8731ccd45bf6c
     * shopLat : 34.75381
     * shopLng : 113.67739
     * shopLogo : https://shop.zjguangxuan.com/userfiles/covimg/201906171748595vKk7y.jpg
     * shopName : 音乐火锅
     * shopSales : 1
     * shopScore : 1
     * shopType : 5
     */

    private String goodsId;
    private String goodsName;
    private String goodsSign;
    private String goodsUnit;
    private String minPrice;
    private String pnum;
    private String shopAddr;
    private String shopDesc;
    private String shopDistance;
    private String shopId;
    private String shopLat;
    private String shopLng;
    private String shopLogo;
    private String shopName;
    private int shopSales;
    private float shopScore;
    /**
     * 店铺推荐商品属性 （0普通零售、1零售团购、2零售满减商品、3零售限时抢购、4厂家直销、5发起拼团商品）
     */
    private int shopType;
    private List<?> couponBeans;
    private List<?> freeCouponList;
    private List<?> goodsList;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSign() {
        return goodsSign;
    }

    public void setGoodsSign(String goodsSign) {
        this.goodsSign = goodsSign;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
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

    public String getShopLat() {
        return shopLat;
    }

    public void setShopLat(String shopLat) {
        this.shopLat = shopLat;
    }

    public String getShopLng() {
        return shopLng;
    }

    public void setShopLng(String shopLng) {
        this.shopLng = shopLng;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getShopSales() {
        return shopSales;
    }

    public void setShopSales(int shopSales) {
        this.shopSales = shopSales;
    }

    public float getShopScore() {
        return shopScore;
    }

    public void setShopScore(float shopScore) {
        this.shopScore = shopScore;
    }

    public int getShopType() {
        return shopType;
    }

    public void setShopType(int shopType) {
        this.shopType = shopType;
    }

    public List<?> getCouponBeans() {
        return couponBeans;
    }

    public void setCouponBeans(List<?> couponBeans) {
        this.couponBeans = couponBeans;
    }

    public List<?> getFreeCouponList() {
        return freeCouponList;
    }

    public void setFreeCouponList(List<?> freeCouponList) {
        this.freeCouponList = freeCouponList;
    }

    public List<?> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<?> goodsList) {
        this.goodsList = goodsList;
    }
}
