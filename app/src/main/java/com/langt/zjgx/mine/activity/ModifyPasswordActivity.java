package com.langt.zjgx.mine.activity;

import android.text.TextUtils;
import android.widget.EditText;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.GlobalFun;
import com.langt.zjgx.server.HttpClient;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ModifyPasswordActivity extends BaseActivity {



    @BindView(R.id.et_origin)
    EditText etOrigin;
    @BindView(R.id.et_newpwd)
    EditText etNewPwd;
    @BindView(R.id.et_newpwd_confirm)
    EditText etNewPwd2;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_modify_pwd;
    }

    @Override
    public void initView() {

    }

    @OnClick(R.id.btn_confirm)
    void confirm(){
        HttpClient httpClient = new HttpClient();
        String old = etOrigin.getText().toString().trim();
        String cur = etNewPwd.getText().toString().trim();
        String cur2 = etNewPwd2.getText().toString().trim();
        if(TextUtils.isEmpty(old)){
            showError("请输入原密码");
        }else if(!TextUtils.equals(cur,cur2)){
            showError("两次输入密码不一致");
        }else{
            httpClient.modifyPassword(GlobalFun.getUserId(),old,cur)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BaseBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BaseBean baseBean) {
                                if(baseBean.isSuccess()){
                                    showError(getString(R.string.modify_success));
                                }else{
                                    showError(baseBean.getResultNote());
                                }
                        }

                        @Override
                        public void onError(Throwable e) {
                            showError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }
}
