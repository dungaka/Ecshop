package com.langt.zjgx.message.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.message.bean.AppealBean;
import com.langt.zjgx.message.presenter.AppealDetailPresenter;
import com.langt.zjgx.message.view.IAppealDetailView;

import butterknife.BindView;

/**
 * 申诉详情页面
 */
public class AppealMsgDetailActivity extends BaseActivity<AppealDetailPresenter>
        implements IAppealDetailView {
    public static final String KEY_APPEAL_BEAN = "key_appeal_bean";

    @BindView(R.id.tv_appeal_type)
    TextView tv_appeal_type;
    @BindView(R.id.tv_appeal_state_un_deal)
    TextView tv_appeal_state_un_deal;
    @BindView(R.id.tv_appeal_state_dealed)
    TextView tv_appeal_state_dealed;
    @BindView(R.id.tv_appeal_title)
    TextView tv_appeal_title;
    @BindView(R.id.tv_appeal_submit_time)
    TextView tv_appeal_submit_time;
    @BindView(R.id.tv_appeal_detail)
    TextView tv_appeal_detail;

    private AppealBean appealBean;

    @Override
    protected AppealDetailPresenter createPresenter() {
        return new AppealDetailPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_appeal_msg_detail;
    }

    @Override
    public void initView() {
        if (getIntent().hasExtra(KEY_APPEAL_BEAN)) {
            appealBean = (AppealBean) getIntent().getSerializableExtra(KEY_APPEAL_BEAN);
        }
        if (appealBean != null) {
            tv_appeal_type.setText(appealBean.getAppealType());
            tv_appeal_title.setText(appealBean.getAppealTitle());
            presenter.getAppealDetail(appealBean.getAppealId());
        }
    }

    @Override
    public void onGetAppealDetail(AppealBean appealBean) {
        hideLoading();
        if (appealBean != null) {
            tv_appeal_type.setText(appealBean.getAppealType());
            tv_appeal_title.setText(appealBean.getAppealTime());
            tv_appeal_detail.setText(appealBean.getAppealContent());

            switch (appealBean.getState()) {
                case Constant.MessageConstant.appeal_type_un_deal:
                    tv_appeal_state_un_deal.setVisibility(View.VISIBLE);
                    tv_appeal_submit_time.setText(appealBean.getAppealTime());
                    break;
                case Constant.MessageConstant.appeal_type_dealed:
                    tv_appeal_state_dealed.setVisibility(View.VISIBLE);
                    tv_appeal_submit_time.setText(appealBean.getHandleTime());
                    break;
            }
        }
    }
}
