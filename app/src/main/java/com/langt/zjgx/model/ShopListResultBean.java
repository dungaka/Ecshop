package com.langt.zjgx.model;

import com.langt.zjgx.base.BaseBean;

import java.util.List;

/**
 * 店铺列表bean
 */
public class ShopListResultBean extends BaseBean {
    private int totalPage;
    private List<ShopBean> shopList;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ShopBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopBean> shopList) {
        this.shopList = shopList;
    }
}
