package com.alvaro.myreportapp

import android.app.Application
import com.google.firebase.BuildConfig
import timber.log.Timber

open class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
