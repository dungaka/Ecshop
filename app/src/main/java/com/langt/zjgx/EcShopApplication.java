package com.langt.zjgx;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.langt.zjgx.base.Constant;
import com.langt.zjgx.login.LoginActivity;
import com.langt.zjgx.utils.ActivityUtils;
import com.langt.zjgx.utils.CoreLib;
import com.langt.zjgx.utils.LogUtils;
import com.langt.zjgx.utils.Utils;
import com.langt.zjgx.utils.carsh.SecyrityCrash;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.session.SessionWrapper;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IMEventListener;

import java.util.List;

import cn.com.superLei.aoparms.AopArms;

public class EcShopApplication extends Application {
    private static final String TAG = "EcShopApplication";
    private static final int TIM_APP_ID = 0;
    private static EcShopApplication context;


    static {
        //设置全局的Header和Footer构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) ->
                new ClassicsHeader(context));
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) ->
                new ClassicsFooter(context)
                        .setProgressResource(R.drawable.ic_refresh)
                        .setDrawableSize(20));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initLocation();
        initTIM();
        initBugly();
        Utils.init(this);
        initAop();
    }

    private void initAop() {
        // https://github.com/aicareles/AopArms
        AopArms.init(this);
        AopArms.setInterceptor((key, methodName) -> {
            Log.e(TAG, "intercept methodName:>>>>>" + methodName);
            if (TextUtils.equals(Constant.InterceptKey.LOGIN_INTERCEPT, key)) {
                String userId = CoreLib.getUserId();
                if (TextUtils.isEmpty(userId)) {
                    // 用户id为空，拦截请求
                    ActivityUtils.startActivity(LoginActivity.class);
                    return true;//代表拦截
                }
            }
            return false;//放行
        });
    }


    public static EcShopApplication getContext() {
        return context;
    }

    /**
     * 地图定位初始化
     */
    private void initLocation() {

    }

    /**
     * 云通信TIM初始化
     */
    private void initTIM() {
        if (SessionWrapper.isMainProcess(this)) {
            TUIKit.init(this, TIM_APP_ID, TUIKit.getConfigs());
            TUIKit.setIMEventListener(new IMEventListener() {
                @Override
                public void onForceOffline() {
                    super.onForceOffline();
                    // 被其他终端踢下线
                    Log.i(TAG, "onForceOffline: 被踢下线");

                }

                @Override
                public void onUserSigExpired() {
                    super.onUserSigExpired();
                    // 用户签名过期了，需要刷新 userSig 重新登录 IM SDK
                    Log.i(TAG, "onUserSigExpired: 用户签名过期");
                }

                @Override
                public void onConnected() {
                    Log.i(TAG, "onConnected");
                }

                @Override
                public void onDisconnected(int code, String desc) {
                    Log.i(TAG, "onDisconnected");
                }

                @Override
                public void onWifiNeedAuth(String name) {
                    Log.i(TAG, "onWifiNeedAuth");
                }

                @Override
                public void onNewMessages(List<TIMMessage> msgs) {
                    super.onNewMessages(msgs);
//                    Log.i(TAG, "onNewMessages: 收到新消息");
                }

            });
        }
    }

    private void initBugly() {
        SecyrityCrash.install();
        SecyrityCrash.setOnExceptionCallBack((t, e, handler) -> {
            // 发生异常
            LogUtils.e("捕获全局异常：" + e.getMessage());
            e.printStackTrace();
        });
    }
}
