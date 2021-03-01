package com.example.weatherappp.data.network.response

import com.example.weatherappp.data.db.entity.CurrentWeatherEntry
import com.example.weatherappp.data.db.entity.WeatherLocation
import com.example.weatherappp.data.db.entity.Request
import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    val location: WeatherLocation,
    val request: Request,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
    )