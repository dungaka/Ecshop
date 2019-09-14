package com.langt.zjgx.goods.bean;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.home.model.GoodsBean;

import java.util.List;

/**
 * 商品列表bean
 */
public class MyGoodsListBean extends BaseBean {
    private List<GoodsBean> goodsList;
    private int totalPage;

    public List<GoodsBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsBean> goodsList) {
        this.goodsList = goodsList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "MyGoodsListBean{" +
                "goodsList=" + goodsList +
                ", totalPage=" + totalPage +
                '}';
    }
}
