package com.example.weatherappp.data.db.provider

import android.content.Context
import com.example.weatherappp.data.db.entity.WeatherLocation

class LocationProviderImpl(context: Context) : PreferenceProvider(context), LocationProvider {
    override suspend fun getPreferredLocationString(): String {
        return "${getCustomLocationName()}"
    }

    private fun hasCustomLocationChanged(lastWeatherLocation: WeatherLocation): Boolean {
        val customLocation = getCustomLocationName()
        return customLocation != lastWeatherLocation.name
    }

    private fun getCustomLocationName(): String? {
        return preference.getString(CHOOSE_LOCATION, null)
    }
}