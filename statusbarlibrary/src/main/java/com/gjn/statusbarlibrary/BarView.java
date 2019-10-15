package com.gjn.statusbarlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by gjn on 2018/6/14.
 */

public class BarView extends View {

    public BarView(Context context) {
        this(context, null);
    }

    public BarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = getResources().getDisplayMetrics().widthPixels;
        int h = StatusBarUtils.getStatusBarHeight(getContext());
        setMeasuredDimension(w, h);
    }
}
