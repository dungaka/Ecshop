package com.langt.zjgx.search.model;

import com.langt.zjgx.base.BaseBean;

import java.util.List;

/**
 * 热门搜索列表
 */
public class HotSearchListResultModel extends BaseBean {
    private List<String> searchKeyList;

    public List<String> getSearchKeyList() {
        return searchKeyList;
    }

    public void setSearchKeyList(List<String> searchKeyList) {
        this.searchKeyList = searchKeyList;
    }

    @Override
    public String toString() {
        return "HotSearchListResultModel{" +
                "searchKeyList=" + searchKeyList +
                '}';
    }
}
