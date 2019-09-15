package com.langt.zjgx.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.langt.zjgx.R;
import com.langt.zjgx.utils.LogUtils;
import com.langt.zjgx.widget.LoadingDialog;
import com.langt.zjgx.widget.stateview.StateView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public Context context;
    protected P presenter;
    public Toast toast;
    private Unbinder mUnbinder;

    private StateView stateView;

    protected abstract P createPresenter();

    protected abstract int getLayoutId();

    public void initData() {
    }

    public abstract void initView();

    public void onErrorCode(BaseBean baseModel) {
        LogUtils.i("请求失败："+baseModel);
        showError(baseModel.getResultNote());
        hideLoading();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = this;
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        this.presenter = createPresenter();
        initBack();
        initView();
        initData();
    }

    protected void injectStateView(View contentView) {
        stateView = StateView.inject(contentView);
    }

    protected void showEmptyView(){
        if (stateView != null) {
            stateView.showEmpty();
        }
    }

    protected void showContentView(){
        if (stateView != null) {
            stateView.showContent();
        }
    }

    private void initBack() {
        TextView tvBack = findViewById(R.id.tv_back);
        if (tvBack != null) {
            if (tvBack.getVisibility() == View.VISIBLE) {
                tvBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.presenter != null) {
            this.presenter.detachView();
        }
        mUnbinder.unbind();
        mUnbinder = null;
    }

    public void showtoast(String str) {
         Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        LoadingDialog.cancelDialogForLoading();
    }

    @Override
    public void showLoading() {
        LoadingDialog.showDialogForLoading(this);
    }

    public void showError(String str) {
        showtoast(str);
    }

    protected void readyGo(Class clz){
        Intent intent = new Intent(this,clz);
        startActivity(intent);
    }

    protected void readyGoWithBundle(Bundle bundle,Class clz){
        Intent intent = new Intent(this,clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 隐藏软键盘
     */
    public void hideSoftKeyboard() {
        try {
            View view = getCurrentFocus();
            if (view != null) {
                IBinder binder = view.getWindowToken();
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(binder, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        } catch (Exception e) {
            Log.w(BaseActivity.class.getSimpleName(), "hideSoftKeyboard: ", e);
        }
    }

    /**
     * 显示软键盘
     *
     * @param editText
     */
    public void showSoftKeyboard(EditText editText) {
        try {
            if (editText != null) {
                editText.requestFocus();
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.showSoftInput(editText, 0);
            }
        } catch (Exception e) {
            Log.w(BaseActivity.class.getSimpleName(), "showSoftKeyboard: ", e);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        hideSoftKeyboard();
    }


}