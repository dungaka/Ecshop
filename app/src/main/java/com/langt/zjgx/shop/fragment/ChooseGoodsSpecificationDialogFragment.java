package com.langt.zjgx.shop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.langt.zjgx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 选择商品规格的弹窗
 */
public class ChooseGoodsSpecificationDialogFragment extends DialogFragment {
    @BindView(R.id.tv_goods_name)
    TextView tv_goods_name;
    @BindView(R.id.tv_goods_price)
    TextView tv_goods_price;
    @BindView(R.id.rv_goods_specification_list)
    RecyclerView rv_goods_specification_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_choose_goods_specification, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_goods_name.setText("03慕兰卡小白心里软面包2kg酸奶夹心口袋吐司面包 多口味可");
        tv_goods_price.setText(getString(R.string.goods_price, "12.5"));
    }
}
