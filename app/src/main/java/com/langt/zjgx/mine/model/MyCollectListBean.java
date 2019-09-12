package com.langt.zjgx.mine.model;

import com.langt.zjgx.base.BaseBean;

import java.util.List;

/**
 * @author SongQinDong
 * @description: 我的收藏
 * @date :2019/7/10 0010 16:47
 */
public class MyCollectListBean extends BaseBean {

    /**
     * {
     * result:"0" //0成功1失败
     * resultNote:"失败原因"
     * totalPage:5//总页数
     * // type = 0时返回
     * goodsList:[{
     * goodsId:""            //商品id
     * goodsImg:"http://fdfaf"    商品图片
     * goodsName:"苹果"        //商品名称
     * skuId:””                //商品规格id
     * goodsCurPrice:""        商品现价
     * goodsOrigPrice:""        //商品规格对应的商品原价
     * }]
     * // type = 1时返回
     * shopList:[{
     * shopId:""            //店铺id
     * shopLogo:"http://fdfaf"    店铺Logo
     * shopName:"丹尼斯"    //店铺名称
     * shopDesc:""            店铺描述
     * }]
     * }
     */

    private int totalPage;
    private List<GoodsListBean> goodsList;
    private List<ShopListBean> shopList;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<GoodsListBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsListBean> goodsList) {
        this.goodsList = goodsList;
    }

    public List<ShopListBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopListBean> shopList) {
        this.shopList = shopList;
    }

    public static class GoodsListBean {
        /**
         * goodsId :
         * goodsImg : http://fdfaf
         * goodsName : 苹果
         * skuId :
         * goodsCurPrice :
         * goodsOrigPrice :
         * goodsOrigPrice :
         */

        private String goodsId;
        private String goodsImg;
        private String goodsName;
        private String skuId;
        private String goodsCurPrice;
        private String goodsOrigPrice;
        private int goodsType;

        public String getGoodsId() {
            return goodsId;
        }

        public int getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(int goodsType) {
            this.goodsType = goodsType;
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

        public String getSkuId() {
            return skuId;
        }

        public void setSkuId(String skuId) {
            this.skuId = skuId;
        }

        public String getGoodsCurPrice() {
            return goodsCurPrice;
        }

        public void setGoodsCurPrice(String goodsCurPrice) {
            this.goodsCurPrice = goodsCurPrice;
        }

        public String getGoodsOrigPrice() {
            return goodsOrigPrice;
        }

        public void setGoodsOrigPrice(String goodsOrigPrice) {
            this.goodsOrigPrice = goodsOrigPrice;
        }
    }

    public static class ShopListBean {
        /**
         * shopId :
         * shopLogo : http://fdfaf
         * shopName : 丹尼斯
         * shopDesc :
         */

        private String shopId;
        private String shopLogo;
        private String shopName;
        private String shopDesc;
        private String shopAddr;

        public String getShopAddr() {
            return shopAddr;
        }

        public void setShopAddr(String shopAddr) {
            this.shopAddr = shopAddr;
        }

        public String getShopId() {
            return shopId;
        }

        public void setShopId(String shopId) {
            this.shopId = shopId;
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

        public String getShopDesc() {
            return shopDesc;
        }

        public void setShopDesc(String shopDesc) {
            this.shopDesc = shopDesc;
        }
    }
}
