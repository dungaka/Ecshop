package com.langt.zjgx.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.adapter.ShopAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.home.presenter.RecommendShopListPresenter;
import com.langt.zjgx.home.view.IRecommendShopListView;
import com.langt.zjgx.model.ShopBean;
import com.langt.zjgx.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 推荐好店列表页面
 */
public class RecommendShopListActivity extends BaseActivity<RecommendShopListPresenter>
        implements OnRefreshLoadMoreListener, BaseQuickAdapter.OnItemClickListener, IRecommendShopListView {
    @BindView(R.id.et_searchView)
    EditText editSearch;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private String mSearchKey = "";
    private int nowPage = 1;
    protected List<ShopBean> shopList;
    private ShopAdapter adapter;

    @Override
    protected RecommendShopListPresenter createPresenter() {
        return new RecommendShopListPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recommend_shop_list;
    }

    @Override
    public void initView() {
        editSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                mSearchKey = editSearch.getText().toString();
                if (TextUtils.isEmpty(mSearchKey)) {
                    ToastUtils.showShort("搜索内容不能为空");
                } else {
                    nowPage = 1;
                    searchShopListWithKey();
                }
                hideSoftKeyboard();
                return true;
            }
            return false;
        });

        refreshLayout.setOnRefreshLoadMoreListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        shopList = new ArrayList<>();
        adapter = new ShopAdapter(shopList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        showLoading();
        searchShopListWithKey();
    }

    private void searchShopListWithKey() {
        presenter.getShopList(mSearchKey, nowPage);
    }

    @Override
    public void onGetShopList(List<ShopBean> shopBeanList) {
        refreshLayout.finishLoadMore();
        refreshLayout.finishRefresh();
        if (shopBeanList != null && shopBeanList.size() > 0) {
            if (nowPage == 1) {
                shopList.clear();
            }
            shopList.addAll(shopBeanList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
