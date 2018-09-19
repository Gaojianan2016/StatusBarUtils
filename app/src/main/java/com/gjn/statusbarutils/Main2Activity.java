package com.gjn.statusbarutils;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;

import com.gjn.statusbarlibrary.BarView;
import com.gjn.statusbarlibrary.StatusBarUtils;

public class Main2Activity extends AppCompatActivity {

    private BarView bv_main2;
    private NestedScrollView nsv_main2;
    private int h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bv_main2 = findViewById(R.id.bv_main2);
        nsv_main2 = findViewById(R.id.nsv_main2);

        StatusBarUtils.statusBarMode(this);
        StatusBarUtils.setContentViewFitsSystemWindows(this, true);

        h = (int) (getResources().getDisplayMetrics().density * 200);

        nsv_main2.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > h) {
                    bv_main2.setBackgroundColor(Color.parseColor("#ffb2b2b2"));
                } else {
                    bv_main2.setBackgroundColor(Color.parseColor("#ff00ddff"));
                }
            }
        });

    }
}
