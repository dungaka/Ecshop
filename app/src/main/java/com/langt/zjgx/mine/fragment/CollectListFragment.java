package com.langt.zjgx.mine.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.adapter.CollectGoodsAdapter;
import com.langt.zjgx.adapter.CollectShopAdapter;
import com.langt.zjgx.adapter.RecycleViewDivider;
import com.langt.zjgx.base.BaseFragment;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.mine.model.CollectGoodsBean;
import com.langt.zjgx.mine.presenter.CollectListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CollectListFragment extends BaseFragment<CollectListPresenter> {
    @BindView(R.id.include_recyclerview)
    RecyclerView recyclerView;

    String type;//0 商品 ；1 店铺

    CollectGoodsAdapter goodsAdapter;
    CollectShopAdapter shopAdapter;
    List<CollectGoodsBean> list;
    @Override
    protected CollectListPresenter createPresenter() {
        return new CollectListPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.include_recyclerview;
    }


    public static CollectListFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString("type",type);
        CollectListFragment fragment = new CollectListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void initView(View view) {
        super.initView(view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecycleViewDivider(getActivity(),LinearLayoutManager.VERTICAL));
        Bundle bundle = getArguments();
//        createData();
        presenter.getMyCollectList(0,1);
        if (bundle!=null){
            String type = bundle.getString("type","0");
            if(!TextUtils.isEmpty(type)&&type.equals("0")){//
                goodsAdapter = new CollectGoodsAdapter(R.layout.item_collectgoods,list);
                recyclerView.setAdapter(goodsAdapter);
            }else{
                shopAdapter = new CollectShopAdapter(R.layout.item_collectshop,list);
                recyclerView.setAdapter(shopAdapter);
            }
        }
    }


    private void createData(){
        list = new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            CollectGoodsBean  bean = new CollectGoodsBean();
            list.add(bean);
        }
    }
}
