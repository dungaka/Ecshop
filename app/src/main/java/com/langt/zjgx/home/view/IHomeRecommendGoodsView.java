package com.langt.zjgx.home.view;

import com.langt.zjgx.base.BaseView;
import com.langt.zjgx.model.GoodsBean;

import java.util.List;

public interface IHomeRecommendGoodsView extends BaseView {
    void onGetGoodsList(List<GoodsBean> goodsBeanList);
}
