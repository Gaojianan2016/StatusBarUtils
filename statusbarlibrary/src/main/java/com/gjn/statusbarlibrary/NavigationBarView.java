package com.gjn.statusbarlibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author gjn
 * @time 2019/3/18 16:07
 */

public class NavigationBarView extends View {
    public NavigationBarView(Context context) {
        this(context, null);
    }

    public NavigationBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = getResources().getDisplayMetrics().widthPixels;
        int h = StatusBarUtils.getNavigationBarHeight(getContext());
        setMeasuredDimension(w, h);
    }
}
