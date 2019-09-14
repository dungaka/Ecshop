package com.langt.zjgx.search.view;

import com.langt.zjgx.base.BaseView;
import com.langt.zjgx.model.GoodsBean;

import java.util.List;

public interface ISearchRersultListView extends BaseView {
    void onGetGoodsList(List<GoodsBean> goodsBeanList);
}
