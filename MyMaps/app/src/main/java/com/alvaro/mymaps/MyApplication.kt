package com.alvaro.mymaps

import android.app.Application
import com.mapbox.mapboxsdk.Mapbox

open class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val key = R.string.mapbox_access_token
        Mapbox.getInstance(this)
    }
}