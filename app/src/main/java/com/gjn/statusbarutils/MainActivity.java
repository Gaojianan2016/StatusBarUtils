package com.gjn.statusbarutils;

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

        if (Build.VERSION.SDK_INT > 23 || android.os.Build.BRAND.contains("Xiaomi")) {
            StatusBarUtils.statusBarMode(this, true, getResources().getColor(R.color.colorTitle));
            textView.setPadding(0, StatusBarUtils.getStatusBarHeight(this), 0, 0);
        } else {
            StatusBarUtils.statusBarMode(this, getResources().getColor(R.color.colorTitle));
        }
    }
}
