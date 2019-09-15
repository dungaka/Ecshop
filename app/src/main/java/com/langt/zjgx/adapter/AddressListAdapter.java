package com.langt.zjgx.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.mine.model.MyAddrListBean;

import java.util.List;

public class AddressListAdapter extends BaseQuickAdapter<MyAddrListBean.AddrListBean, BaseViewHolder> {
    public AddressListAdapter(@Nullable List<MyAddrListBean.AddrListBean> data) {
        super(R.layout.item_my_address,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MyAddrListBean.AddrListBean item) {
        helper.setText(R.id.tv_name,item.getAddrName());


    }
}
