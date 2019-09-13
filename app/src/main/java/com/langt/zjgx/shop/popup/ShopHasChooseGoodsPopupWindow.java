package com.langt.zjgx.shop.popup;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.langt.zjgx.R;
import com.langt.zjgx.home.model.GoodsBean;
import com.langt.zjgx.shop.adapter.ShopHasChooseGoodsAdapter;
import com.langt.zjgx.widget.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 店铺 页面 -已选择商品的弹窗页面
 */
public class ShopHasChooseGoodsPopupWindow extends PopupWindow {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private View contentView;

    private Activity context;

    public ShopHasChooseGoodsPopupWindow(Context context) {
        super(context);
        this.context = (Activity) context;

        contentView = LayoutInflater.from(context).inflate(R.layout.popup_shop_has_choose_goods_list, null);
        ButterKnife.bind(this, contentView);

        setPopupWindow(contentView);

        setInfo();
    }

    private void setPopupWindow(View view) {
        this.setContentView(view);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewPager.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewPager.LayoutParams.WRAP_CONTENT);
        // 在PopupWindow里面就加上下面两句代码，让键盘弹出时，不会挡住pop窗口。
        this.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        // 设置popupWindow以外可以触摸
        this.setOutsideTouchable(true);
        // 以下两个设置点击空白处时，隐藏掉pop窗口
        this.setFocusable(true);
        this.setBackgroundDrawable(new BitmapDrawable());
        // 设置popupWindow以外为半透明0-1 0为全黑,1为全白
        backgroundAlpha(context, 0.5f);
        // 添加pop窗口关闭事件
        this.setOnDismissListener(new PpwDismissListener());
        // 设置动画--这里按需求设置成系统输入法动画
        this.setAnimationStyle(R.style.AnimBottom);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = view.findViewById(R.id.ShopDetailBuyLayout)
                        .getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new DividerDecoration(context));
        List<GoodsBean> specificationList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            specificationList.add(new GoodsBean(""));
        }
        final ShopHasChooseGoodsAdapter mAdapter = new ShopHasChooseGoodsAdapter(specificationList);
        recyclerView.setAdapter(mAdapter);
    }

    private void setInfo() {

    }

    @Override
    public View getContentView() {
        return contentView;
    }

    private void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().setAttributes(lp);
    }

    private class PpwDismissListener implements OnDismissListener {
        @Override
        public void onDismiss() {
            backgroundAlpha(context, 1f);
        }
    }
}
