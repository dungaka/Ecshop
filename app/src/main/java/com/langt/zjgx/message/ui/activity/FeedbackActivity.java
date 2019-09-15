package com.langt.zjgx.message.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.message.presenter.FeedbackPresenter;
import com.langt.zjgx.message.view.IFeedbackView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 意见反馈
 */
public class FeedbackActivity extends BaseActivity<FeedbackPresenter> implements IFeedbackView {
    @BindView(R.id.et_theme)
    EditText et_theme;
    @BindView(R.id.et_content)
    EditText et_content;

    @Override
    protected FeedbackPresenter createPresenter() {
        return new FeedbackPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feed_back;
    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.tv_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:
                submitFeedBack();
                break;
        }
    }

    private void submitFeedBack() {
        String title = et_theme.getText().toString().trim();
        String content = et_content.getText().toString().trim();
        if (TextUtils.isEmpty(title)) {
            showError(getString(R.string.feed_back_theme_tip));
            return;
        }
        if (TextUtils.isEmpty(content)) {
            showError(getString(R.string.feed_back_content_tip));
            return;
        }
        presenter.submitFeedback(title, content);
    }

    @Override
    public void onFeedbackSuccess() {
        finish();
    }
}
