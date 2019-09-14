package com.langt.zjgx.model;

import com.langt.zjgx.base.BaseBean;

import java.util.List;

/**
 * 首页推荐商品
 */
public class HomeRecommendGoodsBean extends BaseBean {
    private String totalPage;
    private List<GoodsBean> goodsList;

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public List<GoodsBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsBean> goodsList) {
        this.goodsList = goodsList;
    }
}
