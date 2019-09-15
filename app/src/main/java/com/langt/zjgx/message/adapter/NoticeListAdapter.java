package com.langt.zjgx.message.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.langt.zjgx.R;
import com.langt.zjgx.message.bean.SystemMessageBean;

import java.util.List;

/**
 * 消息-通知列表adapter
 */
public class NoticeListAdapter extends BaseQuickAdapter<SystemMessageBean, BaseViewHolder> {
    public NoticeListAdapter(@Nullable List<SystemMessageBean> data) {
        super(R.layout.item_notice_message, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, SystemMessageBean item) {
        ImageView iv_image = helper.getView(R.id.iv_image);
        View view_un_read_flag = helper.getView(R.id.view_un_read_flag);
        TextView tv_order_state = helper.getView(R.id.tv_order_state);
        TextView tv_orderNo = helper.getView(R.id.tv_orderNo);
        helper.setText(R.id.tv_notice_type, item.getMessageTitle());
        helper.setText(R.id.tv_notice_time, item.getMessageTime());
        helper.setText(R.id.tv_notice_title, item.getMessageContent());

        view_un_read_flag.setVisibility(item.isRead() ? View.GONE : View.VISIBLE);
        tv_order_state.setText("已发货");
        tv_orderNo.setText(mContext.getString(R.string.order_sn, ""));
    }
}
