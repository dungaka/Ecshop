package com.langt.zjgx.message.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.utils.SPUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.message.MessageLayout;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfo;

import java.util.ArrayList;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Hao on 2019/7/15.
 * Describe
 */
public class ChatActivity extends BaseActivity {

    @BindView(R.id.chat_layout)
    ChatLayout chatLayout;

    private ChatInfo mChatInfo;
    private String mRightIconUrl;
    private String mLeftIconUrl;



    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat;
    }


    @Override
    public void initView() {
        chatLayout.getTitleBar().setVisibility(View.GONE);
        chatLayout.getMessageLayout().setRightIconUrl(mRightIconUrl);
        chatLayout.getMessageLayout().setLeftIconUrl(mLeftIconUrl);
        chatLayout.initDefault();
        chatLayout.setChatInfo(mChatInfo);
        chatLayout.getMessageLayout().setOnItemClickListener(new MessageLayout.OnItemClickListener() {
            @Override
            public void onMessageLongClick(View view, int position, MessageInfo messageInfo) {
                //因为adapter中第一条为加载条目，位置需减1
                chatLayout.getMessageLayout().showItemPopMenu(position - 1, messageInfo, view);
            }

            @Override
            public void onUserIconClick(View view, int position, MessageInfo messageInfo) {
                if (null == messageInfo || null == messageInfo.getTIMMessage()) {
                    return;
                }
            }
        });
    }





    @Override
    protected void onDestroy() {
        chatLayout.exitChat();
        super.onDestroy();
    }
}
