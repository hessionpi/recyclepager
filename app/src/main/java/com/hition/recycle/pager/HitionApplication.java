package com.hition.recycle.pager;

import android.app.Application;

public class HitionApplication extends Application{

    private static HitionApplication instance;

    public static HitionApplication getApplication() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
