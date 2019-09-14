package com.langt.zjgx.search;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.adapter.HomeRecommendGoodsAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.goods.GoodsDetailActivity;
import com.langt.zjgx.home.model.GoodsBean;
import com.langt.zjgx.search.presenter.SearchResultListPresenter;
import com.langt.zjgx.search.view.ISearchRersultListView;
import com.langt.zjgx.utils.ActivityUtils;
import com.langt.zjgx.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 搜索结果展示页面
 */
public class GoodsSearchResultListActivity extends BaseActivity<SearchResultListPresenter>
        implements ISearchRersultListView, BaseQuickAdapter.OnItemClickListener {
    public static final String KEY_FROM_CONTENT = "key_from_content";

    @BindView(R.id.et_searchView)
    EditText editSearch;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private String mSearchKey;
    private List<GoodsBean> list;
    private HomeRecommendGoodsAdapter adapter;
    private int nowPage = 1, totalPage;

    @Override
    protected SearchResultListPresenter createPresenter() {
        return new SearchResultListPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_result_list;
    }

    @Override
    public void initView() {
        if (getIntent() != null) {
            if (getIntent().hasExtra(KEY_FROM_CONTENT)) {
                mSearchKey = getIntent().getStringExtra(KEY_FROM_CONTENT);
            }
        }

        list = new ArrayList<>();
        adapter = new HomeRecommendGoodsAdapter(list, "");
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        editSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                mSearchKey = editSearch.getText().toString();
                if (TextUtils.isEmpty(mSearchKey)) {
                    ToastUtils.showShort("搜索内容不能为空");
                } else {
                    searchGoodsListWithKey();
                }
                return true;
            }
            return false;
        });

    }

    @Override
    public void initData() {
        super.initData();
        searchGoodsListWithKey();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ActivityUtils.startActivity(GoodsDetailActivity.class);
    }

    private void searchGoodsListWithKey() {
        if (TextUtils.isEmpty(mSearchKey)) {
            return;
        }
        presenter.searchGoodsList(mSearchKey, nowPage);
    }

    @Override
    public void onGetGoodsList(List<GoodsBean> goodsBeanList) {
        list.clear();
        if (goodsBeanList != null && goodsBeanList.size() > 0) {
            list.addAll(goodsBeanList);
        }
        adapter.notifyDataSetChanged();
    }
}
