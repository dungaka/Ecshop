package com.langt.zjgx.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by Hao on 2019/5/16.
 * Describe Activity的工具类
 */
public class ActivityUtils {

    public static void startActivity(@NonNull final Class<? extends Activity> clz) {
        Context context = Utils.getTopActivityOrApp();
        startActivity(context, null, context.getPackageName(), clz.getName());
    }

    public static void startActivity(@NonNull final Class<? extends Activity> clz, Bundle bundle) {
        Context context = Utils.getTopActivityOrApp();
        startActivity(context, bundle, context.getPackageName(), clz.getName());
    }

    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Class<? extends Activity> clz) {
        startActivity(activity, null, activity.getPackageName(), clz.getName());
    }

    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Class<? extends Activity> clz,
                                     final Bundle bundle) {
        startActivity(activity, bundle, activity.getPackageName(), clz.getName());
    }

    private static void startActivity(final Context context,
                                      final Bundle extras,
                                      final String pkg,
                                      final String cls) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (extras != null) intent.putExtras(extras);
        intent.setComponent(new ComponentName(pkg, cls));
        startActivity(intent, context);
    }

    public static void startActivity(Intent intent, Context context) {
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    public static void startActivityForResult(Activity fromAct, Class<?> to, int requestCode) {
        startActivityForResult(fromAct, new Intent(fromAct, to), requestCode);
    }

    public static void startActivityForResult(Activity fromAct, Class<?> to, int requestCode, Bundle bundle) {
        startActivityForResult(fromAct, new Intent(fromAct, to).putExtras(bundle), requestCode);
    }

    private static void startActivityForResult(Activity fromAct, Intent intent, int requestCode) {
        fromAct.startActivityForResult(intent, requestCode);
    }
}
