package com.langt.zjgx.mine.model;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.model.GoodsBean;
import com.langt.zjgx.model.ShopBean;

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
    private List<GoodsBean> goodsList;
    private List<ShopBean> shopList;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<GoodsBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsBean> goodsList) {
        this.goodsList = goodsList;
    }

    public List<ShopBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopBean> shopList) {
        this.shopList = shopList;
    }
}
