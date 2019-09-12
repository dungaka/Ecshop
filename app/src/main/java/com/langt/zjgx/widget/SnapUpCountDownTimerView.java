
package com.langt.zjgx.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chaychan.library.UIUtils;
import com.langt.zjgx.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 拼单倒计时
 */
@SuppressLint("HandlerLeak")
public class SnapUpCountDownTimerView extends LinearLayout {

    @BindView(R.id.tv_day)
    TextView tv_day;
    @BindView(R.id.tv_hour)
    TextView tv_hour;
    @BindView(R.id.tv_min)
    TextView tv_min;
    @BindView(R.id.tv_sec)
    TextView tv_sec;

    @BindView(R.id.tv_1)
    TextView tv_1;
    @BindView(R.id.tv_2)
    TextView tv_2;
    @BindView(R.id.tv_3)
    TextView tv_3;

    private int bgColor;
    private int textSize;

    private MyCountDownTimer myCountDownTimer;

    public SnapUpCountDownTimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.widget_countdowntimer, this);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SnapUpCountDownTimerView);
        bgColor = a.getColor(R.styleable.SnapUpCountDownTimerView_bg_color, ContextCompat.getColor(context, R.color.global_middle_text_color));
        float textSize = a.getDimensionPixelSize(R.styleable.SnapUpCountDownTimerView_text_size, 12);
        a.recycle();

        ButterKnife.bind(this, view);

        tv_1.setTextColor(bgColor);
        tv_2.setTextColor(bgColor);
        tv_3.setTextColor(bgColor);

        setTextViewDrawableColor(bgColor, tv_day, tv_hour, tv_min, tv_sec);
        setTextViewSize(textSize, tv_1, tv_2, tv_3, tv_day, tv_hour, tv_min, tv_sec);
    }

    private void setTextViewDrawableColor(int color, TextView... textViewList) {
        if (textViewList == null) {
            return;
        }
        for (TextView textView : textViewList) {
            GradientDrawable myGrad = (GradientDrawable) textView.getBackground();
            myGrad.setColor(color);
            textView.setBackground(myGrad);
        }
    }

    private void setTextViewSize(float size, TextView... textViewList) {
        if (textViewList == null) {
            return;
        }
        for (TextView textView : textViewList) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
        }
    }


    public void start(long time) {
        if (myCountDownTimer == null) {
            myCountDownTimer = new MyCountDownTimer(time, 1000);
        }
        myCountDownTimer.start();
    }


    public void stop() {
        if (myCountDownTimer != null) {
            myCountDownTimer.cancel();
            myCountDownTimer = null;
        }
    }


    private class MyCountDownTimer extends CountDownTimer {
        /**
         * @param millisInFuture    表示以毫秒为单位 倒计时的总数
         *                          <p>
         *                          例如 millisInFuture=1000 表示1秒
         * @param countDownInterval 表示 间隔 多少毫秒 调用一次 onTick 方法
         *                          <p>
         *                          例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            if (onCountDownFinishListener != null) {
                onCountDownFinishListener.onFinish();
            }
        }

        @Override
        public void onTick(long millisUntilFinished) {
            Log.i("MainActivity", millisUntilFinished + "");
            String time = getStandardTime(millisUntilFinished / 1000);
            if (TextUtils.isEmpty(time)) {
                return;
            }
            String[] result = time.split("-");
            if (result.length > 0) {
                for (int i = 0; i < result.length; i++) {
                    switch (i) {
                        case 0:
                            tv_day.setText(result[i]);
                            break;
                        case 1:
                            tv_hour.setText(result[i]);
                            break;
                        case 2:
                            tv_min.setText(result[i]);
                            break;
                        case 3:
                            tv_sec.setText(result[i]);
                            break;
                    }
                }
            }
        }
    }


    /**
     * 转换为标准的时间
     *
     * @param timestamp 时间戳
     */
    private String getStandardTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-HH-mm-ss", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        Date date = new Date(timestamp * 1000);
        sdf.format(date);
        return sdf.format(date);
    }

    private OnCountDownFinishListener onCountDownFinishListener;

    public interface OnCountDownFinishListener {
        void onFinish();
    }

}
