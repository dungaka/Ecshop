package com.langt.zjgx.home;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.goods.GoodsDetailActivity;
import com.langt.zjgx.home.adapter.FullReductionListItemAdapter;
import com.langt.zjgx.model.GoodsBean;

import org.raphets.roundimageview.RoundImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 满减专场更多页面
 */
public class FullReductionZhuanChangFullActivity extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_shop_image)
    RoundImageView iv_shop_image;
    @BindView(R.id.tv_shop_name)
    TextView tv_shop_name;
    @BindView(R.id.tv_shop_manjian_info)
    TextView tv_shop_manjian_info;
    @BindView(R.id.tv_look_more)
    TextView tv_look_more;

    List<GoodsBean> itemList;
    FullReductionListItemAdapter itemAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_full_reduction_zhuan_chang_rull;
    }

    @Override
    public void initView() {
        tv_look_more.setVisibility(View.GONE);
        itemList = new ArrayList<>();
        itemAdapter = new FullReductionListItemAdapter(itemList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(itemAdapter);

        itemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(FullReductionZhuanChangFullActivity.this, GoodsDetailActivity.class));
            }
        });
    }

    @Override
    public void initData() {
        tv_shop_name.setText("天天超市");
        tv_shop_manjian_info.setText("满999减666");
        for (int i = 0; i < 5; i++) {
            itemList.add(new GoodsBean(""));
        }
        itemAdapter.notifyDataSetChanged();
    }
}
