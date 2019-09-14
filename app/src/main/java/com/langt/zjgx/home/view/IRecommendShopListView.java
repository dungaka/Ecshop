package com.langt.zjgx.home.view;

import com.langt.zjgx.base.BaseView;
import com.langt.zjgx.model.ShopBean;

import java.util.List;

public interface IRecommendShopListView extends BaseView {
    void onGetShopList(List<ShopBean> shopBeanList);
}
