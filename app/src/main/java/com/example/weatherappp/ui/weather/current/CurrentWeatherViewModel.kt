package com.example.weatherappp.ui.weather.current

import androidx.lifecycle.ViewModel
import com.example.weatherappp.data.repository.ForecastRepository
import com.example.weatherappp.internal.UnitSystem
import com.example.weatherappp.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.METRIC

    val isMetric
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}