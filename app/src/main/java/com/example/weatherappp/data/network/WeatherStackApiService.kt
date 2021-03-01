package com.example.weatherappp.data.network

import com.example.weatherappp.data.network.ConnectivityInterceptor
import com.example.weatherappp.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "efdf13f44d4adfa60c66f544edc52cfa"

//http://api.openweathermap.org/data/2.5/weather?q=Kazan&appid=a31de27b67c0b3c38627d66eecfb3312
//https://api.weatherstack.com/current?access_key=efdf13f44d4adfa60c66f544edc52cfa&query=London&lang=en
interface WeatherStackApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location: String,
    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): WeatherStackApiService {
            val requestInterceptor = Interceptor { chain ->

                val url =chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherStackApiService::class.java)
        }
    }
}