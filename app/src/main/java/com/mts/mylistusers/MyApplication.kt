package com.mts.mylistusers

import android.app.Application
import android.content.Context
import com.mts.mylistusers.model.Preferences


private const val NAME_PREFERENCES = "lastId"

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Preferences.preferences = getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE)
    }
}
