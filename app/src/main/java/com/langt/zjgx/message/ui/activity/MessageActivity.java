package com.langt.zjgx.message.ui.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.message.presenter.MessageActivityPresenter;
import com.langt.zjgx.message.view.IMessageActivityView;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.component.action.PopActionClickListener;
import com.tencent.qcloud.tim.uikit.component.action.PopDialogAdapter;
import com.tencent.qcloud.tim.uikit.component.action.PopMenuAction;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationListLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationProvider;
import com.tencent.qcloud.tim.uikit.modules.conversation.base.ConversationInfo;
import com.tencent.qcloud.tim.uikit.utils.PopWindowUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity<MessageActivityPresenter> implements IMessageActivityView {


    @BindView(R.id.conversation_layout)
    ConversationLayout conversationLayout;


    private PopDialogAdapter mConversationPopAdapter;
    private PopupWindow mConversationPopWindow;
    private ListView mConversationPopList;
    private List<PopMenuAction> mConversationPopActions = new ArrayList<>();

    @Override
    protected MessageActivityPresenter createPresenter() {
        return new MessageActivityPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    public void initView() {
        conversationLayout.initChatList();
        initConversation();
        conversationLayout.getConversationList().setOnItemClickListener(new ConversationListLayout.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, ConversationInfo messageInfo) {
                ChatInfo chatInfo = new ChatInfo();
                chatInfo.setId(messageInfo.getId());
                chatInfo.setType(TIMConversationType.C2C);
                chatInfo.setChatName(messageInfo.getTitle());
                Intent intent = new Intent(MessageActivity.this, ChatActivity.class);
//                intent.putExtra(Constants.CHAT_INFO, chatInfo);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        conversationLayout.getConversationList().setOnItemLongClickListener(new ConversationListLayout.OnItemLongClickListener() {
            @Override
            public void OnItemLongClick(View view, int position, ConversationInfo messageInfo) {
                float x = view.getX();
                float y = view.getY() + view.getHeight() / 2;
                int[] location = new int[2];
                view.getLocationOnScreen(location);
                showItemPopMenu(position, conversationLayout.getConversationAdapter().getItem(position),
                        x, location[1]);
            }
        });
    }


    private void initConversation() {
        ConversationManagerKit.getInstance().loadConversation(new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {
                ArrayList<String> userIds = new ArrayList<>();
                ConversationProvider provider = (ConversationProvider) data;
                conversationLayout.getConversationAdapter().setDataProvider(provider);

            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                showError(getString(R.string.error_loadmessage_fail));
            }
        });
    }


    private void initPopMenuAction() {
        List<PopMenuAction> conversationPopActions = new ArrayList<>();
        PopMenuAction action = new PopMenuAction();
        action.setActionName("置顶聊天");
        action.setActionClickListener(new PopActionClickListener() {
            @Override
            public void onActionClick(int position, Object data) {
                conversationLayout.setConversationTop(position, (ConversationInfo) data);
            }
        });
        conversationPopActions.add(action);
        action = new PopMenuAction();
        action.setActionClickListener(new PopActionClickListener() {
            @Override
            public void onActionClick(int position, Object data) {
                conversationLayout.deleteConversation(position, (ConversationInfo) data);
            }
        });
        action.setActionName("删除聊天");
        conversationPopActions.add(action);
        mConversationPopActions.clear();
        mConversationPopActions.addAll(conversationPopActions);
    }

    @Override
    public void initData() {
        super.initData();
        presenter.getMessageUnReadCount();
    }

    @OnClick({R.id.tv_notice, R.id.tv_representations, R.id.tv_feedback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_notice:
                startActivity(new Intent(this, NoticeActivity.class));
                break;
            case R.id.tv_representations:
                startActivity(new Intent(this, AppealMsgListActivity.class));
                break;
            case R.id.tv_feedback:
                startActivity(new Intent(this, FeedbackActivity.class));
                break;
        }
    }

    private void showItemPopMenu(final int index, final ConversationInfo conversationInfo, float locationX, float locationY) {
        if (mConversationPopActions == null || mConversationPopActions.size() == 0) {
            return;
        }
        View itemPop = LayoutInflater.from(this).inflate(R.layout.pop_menu_layout, null);
        mConversationPopList = itemPop.findViewById(R.id.pop_menu_list);
        mConversationPopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopMenuAction action = mConversationPopActions.get(position);
                if (action.getActionClickListener() != null) {
                    action.getActionClickListener().onActionClick(index, conversationInfo);
                }
                mConversationPopWindow.dismiss();
            }
        });

        for (int i = 0; i < mConversationPopActions.size(); i++) {
            PopMenuAction action = mConversationPopActions.get(i);
            if (conversationInfo.isTop()) {
                if (action.getActionName().equals("置顶聊天")) {
                    action.setActionName("取消置顶");
                }
            } else {
                if (action.getActionName().equals("取消置顶")) {
                    action.setActionName("置顶聊天");
                }

            }
        }
        mConversationPopAdapter = new PopDialogAdapter();
        mConversationPopList.setAdapter(mConversationPopAdapter);
        mConversationPopAdapter.setDataSource(mConversationPopActions);
        mConversationPopWindow = PopWindowUtil.popupWindow(itemPop, conversationLayout, (int) locationX, (int) locationY);
    }

    @Override
    public void onGetSystemMessageCount(String count) {

    }
}
