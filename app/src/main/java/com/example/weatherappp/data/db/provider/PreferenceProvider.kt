package com.example.weatherappp.data.db.provider

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

abstract class PreferenceProvider(context: Context) {
    private val appContext = context.applicationContext

    protected val preference: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(appContext)
}