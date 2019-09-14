package com.langt.zjgx.cart;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.langt.zjgx.R;
import com.langt.zjgx.adapter.CartGoodsAdapter;
import com.langt.zjgx.adapter.GoodsAdapter;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.category.CategoryListFragment;
import com.langt.zjgx.model.GoodsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CartFragment extends BaseFragment {


    @BindView(R.id.rcy_shop)
    RecyclerView recyclerViewShop;
    @BindView(R.id.rcy_goods)
    RecyclerView recyclerViewGoods;



    private CategoryListFragment mCurrentFragment;

    protected List<GoodsBean> list = new ArrayList<>();
    CartGoodsAdapter adapter;
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_shoppingcar;
    }

    public static CartFragment newInstance() {
        
        Bundle args = new Bundle();
        
        CartFragment fragment = new CartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        super.initData();
        createGoods("");
//        mCurrentFragment = CategoryListFragment.newInstance();
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.add(R.id.layout_container, mCurrentFragment, mCurrentFragment.getClass().getName());
//        transaction.commit();
//        mCurrentFragment.notifyData("");

        recyclerViewShop.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CartGoodsAdapter(R.layout.item_cart_goods,list);
        recyclerViewShop.setAdapter(adapter);

        recyclerViewGoods.setLayoutManager(new GridLayoutManager(getActivity(),2));
        GoodsAdapter adapter2 = new GoodsAdapter(R.layout.item_goods_grid,list);
        recyclerViewGoods.setAdapter(adapter2);

    }

    private void createGoods(String type){
        for (int i = 0; i < 4 ; i++) {
            GoodsBean bean = new GoodsBean("");
            list.add(bean);
        }
    }


}
