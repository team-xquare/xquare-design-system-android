package com.xquare.xds.application

import android.app.Application
import com.google.android.material.color.DynamicColors

class XdsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}
