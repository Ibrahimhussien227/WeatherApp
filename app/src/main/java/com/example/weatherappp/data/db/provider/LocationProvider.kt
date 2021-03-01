package com.example.weatherappp.data.db.provider

import com.example.weatherappp.data.db.entity.WeatherLocation

const val CHOOSE_LOCATION = "CHOOSE_LOCATION"

interface LocationProvider {
    suspend fun getPreferredLocationString(): String
}