package com.example.weatherappp.data.network

import androidx.lifecycle.LiveData
import com.example.weatherappp.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String
    )
}