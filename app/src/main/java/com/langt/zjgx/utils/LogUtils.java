package com.langt.zjgx.utils;

import android.util.Log;

/**
 * 日志工具类
 *
 */
public class LogUtils {
    private static int DEBUG_LEVEL = 6;
    public static String TAG = "cme";

    private static final int VERBOSE = 5;
    private static final int DEBUG = 4;
    private static final int INFO = 3;
    private static final int WARN = 2;
    private static final int ERROR = 1;

    /**
     * 引用时初始化一下，设置是否显示log
     */
    public static void showLog(boolean flag) {
        if (flag) {
            DEBUG_LEVEL = 6;
        } else {
            DEBUG_LEVEL = 0;
        }
        DEBUG_LEVEL = 6;
    }

    public static void logL(String content) {
        logL(TAG, content);
    }

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void w(String msg) {
        w(TAG, msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (DEBUG_LEVEL > VERBOSE) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG_LEVEL > DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (DEBUG_LEVEL > INFO) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (DEBUG_LEVEL > WARN) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG_LEVEL > ERROR) {
            Log.e(tag, msg);
        }
    }


    public static void d(String tag, String msg, Throwable throwable) {
        if (DEBUG_LEVEL > ERROR) {
            Log.d(tag, msg, throwable);
        }
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (DEBUG_LEVEL > ERROR) {
            Log.e(tag, msg, throwable);
        }
    }

    /**
     * 打印长日志的方法(分次打印)
     */
    public static void logL(String tag, String content) {
        if (DEBUG_LEVEL > ERROR) {
            int p = 2000;
            long length = content.length();
            if (length < p || length == p) {
                Log.i(tag, content);
            } else {
                while (content.length() > p) {
                    String logContent = content.substring(0, p);
                    content = content.replace(logContent, "");
                    Log.i(tag, logContent);
                }
                Log.i(tag, content);
            }
        }
    }
}
