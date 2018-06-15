package com.gjn.statusbarutils;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gjn.statusbarlibrary.StatusBarUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("-s-", "sdk = "+ Build.VERSION.SDK_INT);

        StatusBarUtils.statusBarMode(this, true, Color.LTGRAY);

    }
}
