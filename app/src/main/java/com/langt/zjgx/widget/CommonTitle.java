package com.langt.zjgx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.langt.zjgx.R;

/**
 * 通用标题栏
 */

public class CommonTitle extends RelativeLayout {
    private RelativeLayout mRootView;
    // 中间的标题
    private TextView tv_titleCenter;
    /*右边的图片*/
    private ImageView iv_right;
    // 左边的图片
    private ImageView iv_left;
    // 左边的返回按钮
    private TextView back;
    // 标题右边的文本
    private TextView tv_title_right;
    // 标题下部的分割线
    private View divideLine;

    public CommonTitle(Context context) {
        this(context, null);
    }

    public CommonTitle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.widget_common_toolbar_title, this);
        initView();
        initAttrs(context, attrs);
    }

    private void initView() {
        tv_titleCenter = mRootView.findViewById(R.id.tv_title_center);
        back = mRootView.findViewById(R.id.tv_back);
        iv_right = mRootView.findViewById(R.id.iv_title_right);
        iv_left = mRootView.findViewById(R.id.iv_title_left);
        tv_title_right = mRootView.findViewById(R.id.tv_title_right);
        divideLine = mRootView.findViewById(R.id.divideLine);
    }

    /**
     * get Attrs
     */
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CommonTitle);

        String titleCenter = a.getString(R.styleable.CommonTitle_titleCenter);
        int id_iv_left = a.getResourceId(R.styleable.CommonTitle_iv_left, 0);
        int id_iv_right = a.getResourceId(R.styleable.CommonTitle_iv_right, 0);
        int id_tv_right = a.getResourceId(R.styleable.CommonTitle_titleRight, 0);
        boolean isShowBack = a.getBoolean(R.styleable.CommonTitle_showBack, false);
        String titleLeftText = a.getString(R.styleable.CommonTitle_title_left_text);
        int bgColor = a.getResourceId(R.styleable.CommonTitle_title_bg_color, R.color.white);
        a.recycle();

        setBackgroundResource(bgColor);
        if (tv_titleCenter != null) {
            if (!TextUtils.isEmpty(titleCenter)) {
                tv_titleCenter.setText(titleCenter);
            }
        }

        if (id_tv_right > 0 && tv_title_right != null) {
            tv_title_right.setVisibility(View.VISIBLE);
            tv_title_right.setText(id_tv_right);
            tv_title_right.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onTitleClick != null) {
                        onTitleClick.onRightTvClick(v);
                    }
                }
            });
        }

        if (id_iv_left > 0 && iv_left != null) {
            iv_left.setVisibility(View.VISIBLE);
            iv_left.setImageResource(id_iv_left);
        }

        if (id_iv_right > 0 && iv_right != null) {
            iv_right.setVisibility(View.VISIBLE);
            iv_right.setImageResource(id_iv_right);
            iv_right.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onTitleClick != null) {
                        onTitleClick.onRightIvClick(iv_right);
                    }
                }
            });
        }
        if (isShowBack && null != back) {
            back.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(titleLeftText)) {
                back.setCompoundDrawables(null, null, null, null);
                back.setText(titleLeftText);
            }
            back.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onTitleClick != null) {
                        onTitleClick.onLeftIvClick(v);
                    }
                }
            });
        }

//        divideLine.setVisibility(isShowDivideLine ? View.VISIBLE : View.GONE);
        if (divideLine != null) {
            divideLine.setVisibility(View.GONE);
        }
    }

    public void setTitleCenter(String titleCenter) {
        if (tv_titleCenter != null) {
            tv_titleCenter.setText(titleCenter);
        }
    }

    public void setTitleLeftText(String text) {
        if (back != null && !TextUtils.isEmpty(text)) {
            back.setCompoundDrawables(null, null, null, null);
            back.setText(text);
        }
    }

    public void setTitleCenter(int res) {
        setTitleCenter(this.getContext().getString(res));
    }

    public void showBack(boolean showBack) {
        if (back != null) {
            back.setVisibility(showBack ? View.VISIBLE : View.GONE);
        }
    }

    public void showIv_right(boolean showBack) {
        if (null != iv_right) {
            iv_right.setVisibility(showBack ? View.VISIBLE : View.GONE);
        }
    }

    public void setIv_right(int res) {
        if (iv_right != null) {
            iv_right.setImageResource(res);
        }
    }


    public void setTitleRight(String right) {
        if (tv_title_right != null) {
            tv_title_right.setVisibility(VISIBLE);
            tv_title_right.setText(right);
        }
    }

    public String getTitleRight() {
        if (tv_title_right == null) {
            return "";
        }
        return tv_title_right.getText().toString();
    }

    public void setOnTitleClick(OnTitleClick onTitleClick) {
        this.onTitleClick = onTitleClick;
    }

    private OnTitleClick onTitleClick;

    public interface OnTitleClick {
        void onRightIvClick(View view);

        void onRightTvClick(View view);

        void onLeftIvClick(View view);
    }
}
