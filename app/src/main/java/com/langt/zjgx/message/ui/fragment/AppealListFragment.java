package com.langt.zjgx.message.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.message.adapter.AppealListAdapter;
import com.langt.zjgx.message.bean.AppealBean;
import com.langt.zjgx.message.presenter.AppealListPresenter;
import com.langt.zjgx.message.view.IAppealListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 申訴列表頁面
 */
public class AppealListFragment extends BaseFragment<AppealListPresenter>
        implements BaseQuickAdapter.OnItemClickListener, IAppealListView, OnRefreshLoadMoreListener {
    public static final String KEY_MESSAGE_TYPE = "key_message_type";

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<AppealBean> list;
    private AppealListAdapter adapter;

    private int nowPage = 1;

    public static AppealListFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString(KEY_MESSAGE_TYPE, type);
        AppealListFragment fragment = new AppealListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 申诉类型，0-待处理 1-已处理
     */
    private String type;

    @Override
    protected AppealListPresenter createPresenter() {
        return new AppealListPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_only_recyclerview_padding_10;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getString(KEY_MESSAGE_TYPE, Constant.MessageConstant.appeal_type_un_deal);
        }

        list = new ArrayList<>();
        adapter = new AppealListAdapter(type, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        refreshLayout.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void onLazyLoad() {
        getAppealList();
    }

    private void getAppealList() {
        presenter.getAppealList(type, nowPage);
    }

    @Override
    public void onGetAppealList(List<AppealBean> appealBeanList) {
        hideLoading();
        if (appealBeanList != null && appealBeanList.size() > 0) {
            if (nowPage == 1) {
                list.clear();
            }
            list.addAll(appealBeanList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        nowPage++;
        getAppealList();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        nowPage = 1;
        getAppealList();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
