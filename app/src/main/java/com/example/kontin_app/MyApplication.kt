package com.example.kontin_app

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.example.kontin_app.activity.allModule
import com.example.library_base.utils.ToastUtils
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ToastUtils.init(baseContext)
        //初始化ARouter
        if (BuildConfig.DEBUG) {
            ARouter.openLog()    // 打印日志
            ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
        //koin注入
        startKoin {
            androidContext(this@MyApplication)
            modules(allModule)
        }

    }
}