package com.example.schoolanswer;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * Created by 权 on 2018/3/23.
 */

public class MyApplication extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePal.initialize(context);
    }

    public static Context getContext() {
        return context;
    }
}
