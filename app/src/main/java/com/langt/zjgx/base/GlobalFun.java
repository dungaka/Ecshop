package com.langt.zjgx.base;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.langt.zjgx.comm.Constants;
import com.langt.zjgx.utils.SPStaticUtils;
import com.langt.zjgx.utils.SPUtils;

/**
 * Created by Hao on 2019/5/21.
 * Describe 全局参数、方法
 */
public class GlobalFun {

    public  static final String sCachePath = Environment.getExternalStorageDirectory() +
            "/ZHongJuGuangXuan/";

    /**
     * 测试图片
     */
    public static final String TEXT_IMG = "http://pics.sc.chinaz.com/files/pic/pic9/201906/bpic12451.jpg";

    public static final String BASE_URL = "https://shop.zjguangxuan.com/";

    // 微信支付接口url
    public static final String WX_PAY_URL = "https://api.mch.weixin.qq.com/";

    public static String SHARE_APP_IMAGE_URL = "";

    // 腾讯云IM的AppId
    public static final int TIM_APP_ID = 1400205994;

    //微信支付appId
    public static final String WX_APP_ID = "wx654622e26c954a4b";
    //微信商户号
    public static final String WX_MCH_ID = "1510655061";

    // 微信AppSecret
    public static String WEXIN_APP_SECRET = "ab58db161c773d9b37066a64a6524fb0";

    //支付宝支付appId
    public static final String ZFB_APP_ID = "";

    private static Context mContext;

    private static Handler mHandler;

    private static boolean isLogin;

    private static String userId; // 相当于腾讯云IM登录的userId;

    private static String rcToken; // 相当于腾讯云IM登录的userSig

    private static boolean isForceOffline; // 腾讯云是否被踢

    private static String shopToken;

    private static boolean isLocation;

    private static String townId;

    private static int agtState;

    private static String username;

    private static String avatar;

    public static void initialize(Context context) {
        SPStaticUtils.setDefaultSPUtils(SPUtils.getInstance(Constants.COM_CONFIG));
        mContext = context;
        mHandler = new Handler(Looper.getMainLooper());
        isForceOffline = false;
        setTownId(null);
        refreshLoginState();
    }

    public static Context getContext() {
        return mContext;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    public static boolean isLogin() {
        return isLogin;
    }

    public static String getUserId() {
        return userId;
    }

    public static boolean isLocation() {
        return isLocation;
    }

    public static String getTownId() {
        return townId;
    }

    public static String getRcToken() {
        return rcToken;
    }

    public static void setRcToken(String rcToken) {
        GlobalFun.rcToken = rcToken;
    }

    public static String getShopToken() {
        return shopToken;
    }

    public static void setShopToken(String shopToken) {
        GlobalFun.shopToken = shopToken;
    }

    public static int getAgtState() {
        return agtState;
    }

    public static void setAgtState(int agtState) {
        GlobalFun.agtState = agtState;
    }

    public static boolean isIsForceOffline() {
        return isForceOffline;
    }

    public static void setIsForceOffline(boolean isForceOffline) {
        GlobalFun.isForceOffline = isForceOffline;
    }

    /**
     * 注销用于登录
     */
    public static void logout() {
        SPStaticUtils.remove(Constants.USER_PHONE);
//        SPStaticUtils.remove(Constants.PASSWORD);
        SPStaticUtils.remove(Constants.USER_ID);
        SPStaticUtils.remove(Constants.RC_TOKEN);
        SPStaticUtils.remove(Constants.IS_LOGIN);
        refreshLoginState();
    }

    /**
     * 刷新位置信息
     */
    public static void setTownId(String townId) {
        if (TextUtils.isEmpty(townId)) {
            isLocation = false;
        } else {
            isLocation = true;
            GlobalFun.townId = townId;
        }
    }

    /**
     * 刷新登录状态
     */
    public static void refreshLoginState() {
        boolean isLogin = SPStaticUtils.getBoolean(Constants.IS_LOGIN);

        if (isLogin) {
            GlobalFun.rcToken = SPStaticUtils.getString(Constants.RC_TOKEN);
            GlobalFun.userId = SPStaticUtils.getString(Constants.USER_ID);
        } else {
            GlobalFun.rcToken = null;
            GlobalFun.userId = null;
        }
        GlobalFun.isLogin = isLogin;
    }

}
