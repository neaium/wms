package com.lz.wms;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class APP extends Application {
    static final boolean isDebug = true;


    @Override
    public void onCreate() {
        super.onCreate();

        if (isDebug) {
            // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            // Print log
            ARouter.openLog();
            // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
