package com.example.administrator.memo_20170217;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * Created by Administrator on 2017/2/17 0017.
 */
public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePalApplication.initialize(context);
    }

    public static Context getContext(){
        return context;
    }
}
