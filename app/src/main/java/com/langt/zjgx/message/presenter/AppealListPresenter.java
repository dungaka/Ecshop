package com.langt.zjgx.message.presenter;

import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.message.bean.AppealBean;
import com.langt.zjgx.message.bean.AppealListBean;
import com.langt.zjgx.message.view.IAppealListView;

import java.util.ArrayList;
import java.util.List;

public class AppealListPresenter extends BasePresenter<IAppealListView> {
    public AppealListPresenter(IAppealListView iAppealListView) {
        super(iAppealListView);
    }

    /**
     * 获取申诉列表
     *
     * @param state   //0-待处理 1-已处理
     * @param nowPage 当前页码
     */
    public void getAppealList(String state, int nowPage) {
        baseView.showLoading();
        addDisposable(apiClient.getAppealMsgList(state, nowPage), new BaseObserver<AppealListBean>(baseView) {
            @Override
            public void onError(String str) {
                baseView.onGetAppealList(null);
            }

            @Override
            public void onSuccess(AppealListBean bean) {
//                baseView.onGetAppealList(bean.getAppealList());
            }
        });

        List<AppealBean> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            AppealBean appealBean = new AppealBean(Constant.MessageConstant.appeal_type_un_deal,
                    "商品不一致，商品有误商品不一致，商品有误商品不一致，商品有误",
                    "武汉东湖新技术开发区百草味零食天地经销批发的预包装食品、散装食品畅销消费者市场，在消费者当中享有较高的地位，公司与多家零售商和代理商建立了长期稳定的合作关系。武汉东湖新技术开发区百草味零食天地经销的预包装食品、散装食品品种齐全、价格合理。武汉东湖新技术开发区百草味零食天地实力雄厚，重信用、守合同、保证产品质量，以多品种经营特色和薄利多销的原则，赢得了广大客户的信任。");
            result.add(appealBean);
        }
        baseView.onGetAppealList(result);
    }
}
