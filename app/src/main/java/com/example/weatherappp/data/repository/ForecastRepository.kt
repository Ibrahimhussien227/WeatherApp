package com.example.weatherappp.data.repository

import androidx.lifecycle.LiveData
import com.example.weatherappp.data.db.entity.WeatherLocation
import com.example.weatherappp.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}