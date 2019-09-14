package com.langt.zjgx.search;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.search.adapter.MySearchHotKeyAdapter;
import com.langt.zjgx.search.presenter.SearchPresenter;
import com.langt.zjgx.search.view.ISearchView;
import com.langt.zjgx.utils.ActivityUtils;
import com.langt.zjgx.utils.DialogUtils;
import com.langt.zjgx.utils.ListUtil;
import com.langt.zjgx.utils.SPStaticUtils;
import com.langt.zjgx.utils.ToastUtils;
import com.langt.zjgx.widget.flowlayout.TagAdapter;
import com.langt.zjgx.widget.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 搜索页面
 */
public class SearchActivity extends BaseActivity<SearchPresenter> implements ISearchView {
    @BindView(R.id.et_searchView)
    EditText editSearch;
    @BindView(R.id.tag_flow_hot_search)
    TagFlowLayout tagFlowHotSearch;
    @BindView(R.id.tv_clear_all_history)
    TextView tv_clear_all_history;
    @BindView(R.id.tag_flow_search_history)
    TagFlowLayout tagFlowHistory;

    private String mSearchKey;
    private List<String> historyList;
    private List<String> mHotSearchList;
    private TagAdapter tagHistoryAdapter;
    private TagAdapter tagHotSearchAdapter;

    @Override
    protected SearchPresenter createPresenter() {
        return new SearchPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        editSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                mSearchKey = editSearch.getText().toString();
                if (TextUtils.isEmpty(mSearchKey)) {
                    ToastUtils.showShort("搜索内容不能为空");
                } else {
                    saveSearchKey(mSearchKey);
                    toSearchResult(mSearchKey);
                }
                return true;
            }
            return false;
        });
        mHotSearchList = new ArrayList<>();
        historyList = new ArrayList<>();

        // 热搜
        tagHotSearchAdapter = new MySearchHotKeyAdapter(this,tagFlowHotSearch,mHotSearchList);
        tagFlowHotSearch.setAdapter(tagHotSearchAdapter);
        tagFlowHotSearch.setOnTagClickListener((view, position, parent) -> {
            toSearchResult(mHotSearchList.get(position));
            return false;
        });

        // 历史搜索
        tagHistoryAdapter = new MySearchHotKeyAdapter(this,tagFlowHistory,historyList);
        tagFlowHistory.setAdapter(tagHistoryAdapter);
        tagFlowHistory.setOnTagClickListener((view, position, parent) -> {
            toSearchResult(historyList.get(position));
            return false;
        });
    }

    @Override
    public void initData() {
        super.initData();
        getHotSearch();
        getHistorySearch();
    }

    @Override
    public void onGetHotSearchList(List<String> hotSearchList) {
        if (hotSearchList != null && hotSearchList.size()>0) {
            mHotSearchList.clear();
            mHotSearchList.addAll(hotSearchList);
            tagHotSearchAdapter.notifyDataChanged();
        }
    }

    /**
     * 跳转到搜索结果
     */
    private void toSearchResult(String searchKey) {
        hideSoftKeyboard();
        Intent intent = new Intent(this, GoodsSearchResultListActivity.class);
        intent.putExtra(GoodsSearchResultListActivity.KEY_FROM_CONTENT,searchKey);
        ActivityUtils.startActivity(intent,this);
    }

    /**
     * 获取热门搜索
     */
    private void getHotSearch() {
        presenter.getHostSearchList();
    }

    /**
     * 获取历史搜索
     */
    private void getHistorySearch() {
        historyList.clear();
        String history = SPStaticUtils.getString(Constant.SpConstant.GOODS_SEARCH_KEY);
        String[] keys = history.split("@");
        List<String> allKey = Arrays.asList(keys);
        for (int i = 0; i < allKey.size(); i++) {
            if (!TextUtils.isEmpty(allKey.get(i)) && !historyList.contains(allKey.get(i))) {
                historyList.add(allKey.get(i));
            }
        }
        Collections.reverse(historyList);
        if (historyList.size() > 20) {
            historyList = historyList.subList(0, 20);
        }
        if (tagHistoryAdapter != null) {
            tagHistoryAdapter.notifyDataChanged();
        }
        if (ListUtil.isEmpty(historyList)) {
            tagFlowHistory.setVisibility(View.GONE);
            tv_clear_all_history.setVisibility(View.GONE);
        } else {
            tagFlowHistory.setVisibility(View.VISIBLE);
            tv_clear_all_history.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 保存搜索的关键字
     */
    private void saveSearchKey(@NonNull String searchKey) {
        String historyKey;
        historyKey = SPStaticUtils.getString(Constant.SpConstant.GOODS_SEARCH_KEY) + searchKey + "@";
        SPStaticUtils.put(Constant.SpConstant.GOODS_SEARCH_KEY, historyKey);
        if (tagHistoryAdapter != null) {
            tagHistoryAdapter.notifyDataChanged();
        }
    }

    @OnClick({R.id.tv_clear_all_history})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_clear_all_history:
                AlertDialog alertDialog = DialogUtils.createDialog(this,
                        "你确定要删除所有历史记录么？",
                        (dialog, which) -> {
                            SPStaticUtils.remove(Constant.SpConstant.GOODS_SEARCH_KEY);
                            getHistorySearch();
                        }, (dialog, which) -> {

                        });
                alertDialog.show();
                break;
        }
    }
}
