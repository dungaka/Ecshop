package com.langt.zjgx.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.langt.zjgx.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品数量选择器
 */
public class GoodsNumberPicker extends LinearLayout {
    @BindView(R.id.image_minus)
    ImageView image_minus;
    @BindView(R.id.image_plus)
    ImageView image_plus;
    @BindView(R.id.text_number)
    TextView text_number;

    private int number;

    public GoodsNumberPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_goods_number_picker, this, true);
        ButterKnife.bind(this);

        number = 1;
        text_number.setText(String.valueOf(number));

    }

    @OnClick({R.id.image_minus, R.id.image_plus})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.image_minus:
                if (number <= 1) {
                    number = 1;
                }
                number--;
                if (onNumberChangeListener != null) {
                    text_number.setText(String.valueOf(number));
                    onNumberChangeListener.onNumberChange(number);
                }
                break;
            case R.id.image_plus:
                if (number <= 0) {
                    number = 0;
                }
                number++;
                if (onNumberChangeListener != null) {
                    text_number.setText(String.valueOf(number));
                    onNumberChangeListener.onNumberChange(number);
                }
                break;
        }
    }

    private OnNumberChangeListener onNumberChangeListener;

    public void setOnNumberChangeListener(OnNumberChangeListener onNumberChangeListener) {
        this.onNumberChangeListener = onNumberChangeListener;
    }

    public interface OnNumberChangeListener {
        void onNumberChange(int number);
    }
}
