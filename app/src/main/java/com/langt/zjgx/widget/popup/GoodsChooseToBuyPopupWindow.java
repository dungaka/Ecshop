package com.langt.zjgx.widget.popup;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.langt.zjgx.R;
import com.langt.zjgx.shop.adapter.ShopPopupSpecificationAdapter;
import com.langt.zjgx.widget.SimpleNumberPicker;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 选择商品规格的弹窗
 */
public class GoodsChooseToBuyPopupWindow extends PopupWindow {
    @BindView(R.id.iv_goods_pic)
    ImageView iv_goods_pic;
    @BindView(R.id.ShopDetailBuyLayout)
    LinearLayout ShopDetailBuyLayout;
    @BindView(R.id.tv_goods_name)
    TextView tv_goods_name;
    @BindView(R.id.tv_goods_price)
    TextView tv_goods_price;
    @BindView(R.id.rv_goods_specification_list)
    RecyclerView recyclerView;
    @BindView(R.id.number_picker)
    SimpleNumberPicker number_picker;
    @BindView(R.id.tv_add_to_shopping_cart)
    TextView tv_add_to_shopping_cart;

    private Activity context;

    public GoodsChooseToBuyPopupWindow(Context context) {
        super(context);
        this.context = (Activity) context;
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_choose_goods_specification, null);
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

        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        List<String> specificationList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            specificationList.add("");
        }
        final ShopPopupSpecificationAdapter mAdapter = new ShopPopupSpecificationAdapter(specificationList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mAdapter.setSelectPosition(position);
            }
        });
    }

    private void setInfo() {
        tv_goods_name.setText("03慕兰卡小白心里软面包2kg酸奶夹心口袋吐司面包 多口味可");
        tv_goods_price.setText(context.getString(R.string.goods_price, "25.6"));
    }

    @OnClick({R.id.tv_add_to_shopping_cart})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_add_to_shopping_cart:
                confirmAddToShoppingCar();
                break;
        }
    }

    private void confirmAddToShoppingCar() {
        dismiss();
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
