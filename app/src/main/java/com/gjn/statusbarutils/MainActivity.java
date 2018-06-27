package com.gjn.statusbarutils;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.gjn.statusbarlibrary.StatusBarUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tv_top);

        Log.e("-s-", "sdk = " + Build.VERSION.SDK_INT);
        Log.e("-s-", "BRAND = " + android.os.Build.BRAND);

        StatusBarUtils.statusBarMode(this, true, Color.RED);
        StatusBarUtils.setContentViewFitsSystemWindows(this, true);
    }
}
