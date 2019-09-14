package com.langt.zjgx.search.view;

import com.langt.zjgx.base.BaseView;

import java.util.List;

public interface ISearchView extends BaseView {
    void onGetHotSearchList(List<String> hotSearchList);
}
