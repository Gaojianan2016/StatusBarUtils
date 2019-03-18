# StatusBarUtils
# 状态栏工具类

```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}


dependencies {
    implementation 'com.github.Gaojianan2016:StatusBarUtils:1.0.4'
}
```

# 基本使用
MainActivity.class
<br >
![基本使用](https://github.com/Gaojianan2016/ImgData/blob/master/StatusBarUtils_Demo/StatusBarUtils_1.png)
<br >
```
package com.gjn.statusbarutils;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.gjn.statusbarlibrary.StatusBarUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("-s-", "sdk = " + Build.VERSION.SDK_INT);
        Log.e("-s-", "BRAND = " + android.os.Build.BRAND);

        StatusBarUtils.statusBarMode(this, true, Color.GREEN);
        StatusBarUtils.setContentViewFitsSystemWindows(this, true);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });
    }
}
```

# 侧滑应用1
Main2Activity.class
<br >
![侧滑应用1](https://github.com/Gaojianan2016/ImgData/blob/master/StatusBarUtils_Demo/StatusBarUtils_3.png)
<br >
```
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
```

# 侧滑应用2
Main3Activity.class
<br >
![侧滑应用2](https://github.com/Gaojianan2016/ImgData/blob/master/StatusBarUtils_Demo/StatusBarUtils_2.png)
<br >
```
package com.gjn.statusbarutils;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
```

