package com.langt.zjgx.mine.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.AddressListAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BaseObserver;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.GlobalFun;
import com.langt.zjgx.mine.model.MyAddrListBean;
import com.langt.zjgx.server.HttpClient;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddressManagerActivity extends BaseActivity implements OnRefreshListener {



    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    int curPage = 0;

    List<MyAddrListBean.AddrListBean> addrList;

    AddressListAdapter adapter;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_address_manager;
    }

    @Override
    public void initView() {


        getMyAddrList();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AddressListAdapter(addrList);
        recyclerView.setAdapter(adapter);

    }


    @OnClick(R.id.tv_add_address)
    void createAddr(){
        Intent intent = new Intent(this,NewAddrActivity.class);
        startActivity(intent);

    }


    private void getMyAddrList(){
        HttpClient client = new HttpClient();
        client.getMyAddrList(GlobalFun.getUserId(),curPage).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new BaseObserver<MyAddrListBean>(this) {
            @Override
            public void onError(String str) {
                    showError(str);
            }

            @Override
            public void onSuccess(MyAddrListBean myAddrListBean) {
                    if(myAddrListBean.getAddrList()!=null&&myAddrListBean.getAddrList().size()>0){
                        addrList = myAddrListBean.getAddrList();
                        adapter.notifyDataSetChanged();
                    }
            }
        });
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        getMyAddrList();

    }
}
