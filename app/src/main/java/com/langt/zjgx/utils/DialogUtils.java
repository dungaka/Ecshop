package com.langt.zjgx.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.langt.zjgx.R;

/**
 * Created by hao on 2019/4/4.
 * Describe dialog弹窗工具类，用于显示各种弹窗
 */
public class DialogUtils {

    public static AlertDialog createLoadingDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Dialog)
                .setView(R.layout.dialog_loading)
                .setCancelable(false);
        return builder.create();
    }

    public static AlertDialog createDialog(Context context, String message,
                                           DialogInterface.OnClickListener positiveClick,
                                           DialogInterface.OnClickListener negativeClick) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(R.string.action_ensure, positiveClick)
                .setNegativeButton(R.string.action_cancel, negativeClick);
        return builder.create();
    }

    public static AlertDialog customDialog(Context context, int anchor, String message,
                                           DialogInterface.OnClickListener positiveClick,
                                           DialogInterface.OnClickListener negativeClick){
        //实例化布局
        View view = LayoutInflater.from(context).inflate(anchor,null);
        //创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setMessage(message)
                .setPositiveButton(R.string.action_ensure, positiveClick)
                .setNegativeButton(R.string.action_cancel, negativeClick);
        return builder.create();
    }



}
