package com.langt.zjgx.goods.bean;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.home.model.GoodsBean;

import java.util.List;

/**
 * 商品列表bean
 */
public class MyGoodsListBean extends BaseBean {
    private List<GoodsBean> goodsList;

    public List<GoodsBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsBean> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "GoodsListBean{" +
                "goodsList=" + goodsList +
                '}';
    }
}
