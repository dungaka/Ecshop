package com.langt.zjgx.category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.SimpleTabAdapter;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class CategoryFragment extends BaseFragment {



    @BindView(R.id.tablayout)
    VerticalTabLayout tabLayout;


    private CategoryListFragment mCurrentFragment;
    private String[] tabs = {"休闲零食","蔬果生鲜","百  货","母婴精品","童装鞋帽","居家百货"};
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_category;
    }

    public static CategoryFragment newInstance() {

        Bundle args = new Bundle();

        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initData() {
        super.initData();
        mCurrentFragment = CategoryListFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.layout_container, mCurrentFragment, mCurrentFragment.getClass().getName());
        transaction.commit();

        createTabs();

    }

    private void createTabs() {
        tabLayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return tabs.length;
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return new ITabView.TabTitle.Builder().setContent(tabs[position]).build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });

        tabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                tab.getTitleView().setTextColor(getResources().getColor(R.color.colortheme));
                Log.i("TAG","position = "+position);
                Log.i("TAG","tab = "+tabs[position]);
                if(mCurrentFragment!=null){
                    mCurrentFragment.notifyData(tabs[position]);
                }

            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

    }
}
