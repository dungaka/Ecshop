package com.langt.zjgx.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import com.langt.zjgx.EcShopApplication;


public class NetworkUtil {

    /**
     * 网络状态
     *
     * @return boolean true网络连接正常
     */
    public static boolean getNetworkStatus() {
        ConnectivityManager manager = (ConnectivityManager) EcShopApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = manager.getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isAvailable()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 网络类型判断
     *
     * @return 0是无网络  1是WIFI  2是2G 3是3G 4是4G
     */
    public static int isWifiOr2GNetWork(Context context) {
        int flag = 0;
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = manager.getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.isAvailable()) {
            if (networkinfo.getType() == ConnectivityManager.TYPE_WIFI) {
                flag = 1;
            } else if (networkinfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                int subType = networkinfo.getSubtype();
                if (subType == TelephonyManager.NETWORK_TYPE_CDMA
                        || subType == TelephonyManager.NETWORK_TYPE_GPRS
                        || subType == TelephonyManager.NETWORK_TYPE_EDGE) {
                    flag = 2;
                } else if (subType == TelephonyManager.NETWORK_TYPE_UMTS
                        || subType == TelephonyManager.NETWORK_TYPE_HSDPA
                        || subType == TelephonyManager.NETWORK_TYPE_EVDO_A
                        || subType == TelephonyManager.NETWORK_TYPE_EVDO_0
                        || subType == TelephonyManager.NETWORK_TYPE_EVDO_B
                        || subType == TelephonyManager.NETWORK_TYPE_HSPAP) {
                    flag = 3;
                } else if (subType == TelephonyManager.NETWORK_TYPE_LTE) {// LTE是3g到4g的过渡，是3.9G的全球标准
                    flag = 4;
                } else {
                    flag = 3;
                }
            }

        } else {
            flag = 0;// 无网络
        }
        return flag;
    }

    // 使用 wifi
    public static boolean getWifiStatus(Context context) {
        //获取wifi服务
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isWifiEnabled();
    }
}
