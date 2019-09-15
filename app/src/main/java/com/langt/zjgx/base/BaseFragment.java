package com.langt.zjgx.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.langt.zjgx.utils.LogUtils;
import com.langt.zjgx.widget.LoadingDialog;
import com.langt.zjgx.widget.stateview.StateView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    public Context context;
    private ProgressDialog dialog;
    protected P presenter;
    public Toast toast;
    protected Unbinder unbinder;

    private StateView stateView;

    /**
     * 该页面是否已准备完毕，onCreTeView方法已调用完毕
     */
    private boolean isPrepared;
    /**
     * 该Fragment是否已执行过懒加载
     */
    private boolean isLazyLoaded;

    protected abstract P createPresenter();

    protected abstract int getLayoutId();

    public void initData() {
    }

    public void initView(View view) {
    }

    public void onErrorCode(BaseBean baseModel) {
        LogUtils.i("请求失败："+baseModel);
        hideLoading();
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

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View layoutInflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        unbinder = ButterKnife.bind(this, layoutInflate);
        this.context = getContext();
        this.presenter = createPresenter();
        isPrepared = true;
        initView(layoutInflate);
        lazyLoad();
        initData();
        return layoutInflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.presenter != null) {
            this.presenter.detachView();
        }
        unbinder.unbind();
        unbinder = null;
    }

    public void showtoast(String str) {
        if (this.toast == null) {
            this.toast = Toast.makeText(getContext(), str, Toast.LENGTH_SHORT);
        }
        this.toast.setText(str);
        this.toast.show();
    }

    private void lazyLoad(){
        if (getUserVisibleHint() && isPrepared && !isLazyLoaded) {
            onLazyLoad();
            isLazyLoaded = true;
        }
    }

    @UiThread
    protected void onLazyLoad(){}


    public void buildProgressDialog(String str) {
        LoadingDialog.showDialogForLoading(getActivity());
    }

    public void cancelProgressDialog() {
        Log.d("Loading", "取消加载框");
        LoadingDialog.cancelDialogForLoading();
    }


    public void readyGo(Class clz){
        Intent intent = new Intent(getActivity(),clz);
        getActivity().startActivity(intent);
    }

    public void showFileDialog() {
        this.dialog = new ProgressDialog(this.context);
        this.dialog.setMessage("正在下载中,请稍后");
        this.dialog.setProgressStyle(1);
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.setMax(100);
        this.dialog.show();
    }

    public void hideFileDialog() {
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    private void closeLoadingDialog() {
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    private void showLoadingDialog() {
        if (this.dialog == null) {
            this.dialog = new ProgressDialog(this.context);
        }
        this.dialog.setCancelable(false);
        this.dialog.show();
    }

    public void showLoading() {
        showLoadingDialog();
    }

    public void hideLoading() {
        closeLoadingDialog();
    }

    public void showError(String str) {
        showtoast(str);
    }

    public void showLoadingFileDialog() {
        showFileDialog();
    }

    public void hideLoadingFileDialog() {
        hideFileDialog();
    }

    public void onProgress(long j, long j2) {
        if (this.dialog != null) {
            this.dialog.setProgress((int) ((j2 * 100) / j));
        }
    }
}