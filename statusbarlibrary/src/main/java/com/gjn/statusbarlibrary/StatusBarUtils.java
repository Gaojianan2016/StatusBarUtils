package com.gjn.statusbarlibrary;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by gjn on 2018/6/14.
 */

public class StatusBarUtils {
    private static final String TAG = "StatusBarUtils";

    public static void statusBarMode(Activity activity) {
        statusBarMode(activity, false);
    }

    public static void statusBarMode(Activity activity, boolean isDark) {
        statusBarMode(activity, isDark, null);
    }

    public static void statusBarMode(Activity activity, Drawable drawable) {
        statusBarMode(activity, false, drawable);
    }

    public static void statusBarMode(Activity activity, int color) {
        statusBarMode(activity, false, color);
    }

    public static void statusBarMode(Activity activity, boolean isDark, Drawable drawable) {
        //透明状态栏
        setStatusBarTranslucent(activity);
        //设置barview背景颜色
        setBarBackgroundDrawable(activity, drawable);
        //状态栏模式
        if (setMIUIBarMode(activity, isDark)) {
            return;
        }
        setBarModeV23(activity, isDark);
    }


    public static void statusBarMode(Activity activity, boolean isDark, int color) {
        //透明状态栏
        setStatusBarTranslucent(activity);
        //设置barview背景颜色
        setBarBackgroundColor(activity, color);
        //状态栏模式
        if (setMIUIBarMode(activity, isDark)) {
            return;
        }
        setBarModeV23(activity, isDark);
    }

    public static void setStatusBarTranslucent(Activity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //透明状态栏
            window.setStatusBarColor(Color.TRANSPARENT);
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    public static int getStatusBarHeight(Context context) {
        int barId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(barId);
    }

    public static void setBarBackgroundColor(Activity activity, int background) {
        setStatusBarBackground(activity, 0, background);
    }

    public static void setBarBackgroundDrawable(Activity activity, Drawable background) {
        setStatusBarBackground(activity, 1, background);
    }

    public static void setBarBackgroundResource(Activity activity, int background) {
        setStatusBarBackground(activity, 2, background);
    }

    private static void setStatusBarBackground(Activity activity, int type, Object object) {
        if (object == null) {
            Log.e(TAG, "object is null.");
            return;
        }
        ViewGroup group = activity.findViewById(android.R.id.content);
        for (int i = 0; i < group.getChildCount(); i++) {
            if (group.getChildAt(i) instanceof BarView) {
                group.removeViewAt(i);
            }
        }
        BarView view = new BarView(activity);
        if (type == 1) {
            view.setBackground((Drawable) object);
        } else if (type == 2) {
            view.setBackgroundResource((Integer) object);
        } else {
            view.setBackgroundColor((Integer) object);
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight(activity));
        group.addView(view, lp);
    }

    public static void setContentViewFitsSystemWindows(Activity activity, boolean flag) {
        ViewGroup content = activity.findViewById(android.R.id.content);
        for (int i = 0; i < content.getChildCount(); i++) {
            if (!(content.getChildAt(i) instanceof BarView)) {
                content.getChildAt(i).setFitsSystemWindows(flag);
            }
        }
    }

    public static boolean setMIUIBarMode(Activity activity, boolean dark) {
        Window window = activity.getWindow();
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int modeFlag;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                modeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (dark) {
                    //透明状态栏 黑色字体
                    extraFlagField.invoke(window, modeFlag, modeFlag);
                } else {
                    //白色字体
                    extraFlagField.invoke(window, 0, modeFlag);
                }
                //开发版 7.7.13及以后版本采用了安卓6.0系统API
                setBarModeV23(activity, dark);
                return true;
            } catch (Exception e) {
                Log.i(TAG, "不是小米手机");
            }
        }
        return false;
    }

    public static void setBarModeV23(Activity activity, boolean dark) {
        View decorView = activity.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (dark) {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
        }
    }
}
