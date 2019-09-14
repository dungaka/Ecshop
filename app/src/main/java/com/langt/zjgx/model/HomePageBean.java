package com.langt.zjgx.model;

import com.langt.zjgx.base.BaseBean;

import java.util.List;

/**
 * 首页数据
 */
public class HomePageBean extends BaseBean {


    private List<Banner> adList;
    private List<ShopBean> shopList;

    public List<Banner> getAdList() {
        return adList;
    }

    public void setAdList(List<Banner> adList) {
        this.adList = adList;
    }

    public List<ShopBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopBean> shopList) {
        this.shopList = shopList;
    }
}
