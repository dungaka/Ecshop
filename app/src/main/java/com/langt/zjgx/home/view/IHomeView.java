package com.langt.zjgx.home.view;

import com.langt.zjgx.base.BaseView;
import com.langt.zjgx.model.HomePageBean;

public interface IHomeView extends BaseView {
    void onGetHomePageInfo(HomePageBean homePageBean);
}
