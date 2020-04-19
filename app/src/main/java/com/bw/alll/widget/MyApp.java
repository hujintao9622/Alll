package com.bw.alll.widget;


import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * date:2020/4/13 0013
 * author:胡锦涛(Administrator)
 * function:
 */
public class MyApp extends Application {
    public static Context mcontext;
    @Override
    public void onCreate() {
        super.onCreate();
        mcontext=this;
        //初始化fresco
        Fresco.initialize(this);
    }
}
