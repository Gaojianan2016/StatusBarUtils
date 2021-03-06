package com.gjn.statusbarutils;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gjn.statusbarlibrary.StatusBarUtils;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        StatusBarUtils.statusBarMode(this, Color.parseColor("#ffb2b2b2"));
        StatusBarUtils.setContentViewFitsSystemWindows(this, true);
    }
}
