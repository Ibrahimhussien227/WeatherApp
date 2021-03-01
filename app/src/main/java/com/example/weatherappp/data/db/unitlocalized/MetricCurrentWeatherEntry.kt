package com.example.weatherappp.data.db.unitlocalized

import androidx.room.ColumnInfo
import com.example.weatherappp.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

data class MetricCurrentWeatherEntry(
    @ColumnInfo(name = "temperature")
    override val temperature: Double,
    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Double,
    @ColumnInfo(name = "windDir")
    override val windDirection: String,
    @ColumnInfo(name = "precip")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslike")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double
) : UnitSpecificCurrentWeatherEntry