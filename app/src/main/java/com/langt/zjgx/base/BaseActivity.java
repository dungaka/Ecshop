package com.langt.zjgx.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.langt.zjgx.widget.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public Context context;
    protected P presenter;
    public Toast toast;
    private Unbinder mUnbinder;

    protected abstract P createPresenter();

    protected abstract int getLayoutId();

    public void initData() {
    }

    public abstract void initView();

    public void onErrorCode(BaseModel baseModel) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = this;
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        this.presenter = createPresenter();

        initView();
        initData();
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
        if (this.toast == null) {
            this.toast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
        }
        this.toast.show();
    }

    public void showLoadingDialog(String str) {
        LoadingDialog.showDialogForLoading(this);
    }

    public void closeLoadingDialog() {
        Log.d("Loading", "取消加载框");
      LoadingDialog.cancelDialogForLoading();
    }


    public void showError(String str) {
        showtoast(str);
    }


}