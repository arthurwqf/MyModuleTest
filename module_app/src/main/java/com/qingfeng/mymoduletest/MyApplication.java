package com.qingfeng.mymoduletest;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.qingfeng.lib_common.BaseApplication;

/**
 * Created by D on 2018/4/27 0027.
 */

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebug()) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private boolean isDebug() {
        if (isSpace(this.getPackageName())) return false;
        try {
            PackageManager pm = this.getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(this.getPackageName(), 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isSpace(String s) {
        return (s == null || s.trim().length() == 0);
    }
}
