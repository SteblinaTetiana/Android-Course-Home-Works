package com.triare.p111weather.api

import com.triare.p111weather.model.WeatherDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherService {
    @Headers("X-RapidAPI-Key: b27c4efa4emsh188572dad90af06p126a4djsnf001b4725418")
    @GET("current?lang=ru")
    fun getWeatherCurrent(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float
    ): Call<WeatherDto>

    @Headers("X-RapidAPI-Key: b27c4efa4emsh188572dad90af06p126a4djsnf001b4725418")
    @GET("forecast/hourly?lang=ru")
    fun getWeatherHourly(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float
    ): Call<WeatherDto>
}