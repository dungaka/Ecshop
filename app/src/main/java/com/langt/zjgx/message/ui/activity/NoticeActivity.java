package com.langt.zjgx.message.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.message.adapter.NoticeListAdapter;
import com.langt.zjgx.message.bean.SystemMessageBean;
import com.langt.zjgx.message.presenter.NoticePresenter;
import com.langt.zjgx.message.view.INoticeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 通知页面
 */
public class NoticeActivity extends BaseActivity<NoticePresenter>
        implements INoticeView, BaseQuickAdapter.OnItemClickListener, OnRefreshLoadMoreListener {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private int nowPage = 1;
    private List<SystemMessageBean> list;
    private NoticeListAdapter adapter;

    @Override
    protected NoticePresenter createPresenter() {
        return new NoticePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_notice;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        adapter = new NoticeListAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        refreshLayout.setOnRefreshLoadMoreListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        getNoticeList();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        nowPage++;
        getNoticeList();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        nowPage = 1;
        getNoticeList();
    }

    @Override
    public void onGetNoticeList(List<SystemMessageBean> messageBeanList) {
        refreshLayout.finishLoadMore();
        refreshLayout.finishRefresh();
        if (messageBeanList != null && messageBeanList.size() > 0) {
            if (nowPage == 1) {
                list.clear();
            }
            list.addAll(messageBeanList);
            adapter.notifyDataSetChanged();
        }
    }

    private void getNoticeList() {
        presenter.getNoticeMessageList(nowPage);
    }
}
