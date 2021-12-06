package com.triare.p111weather

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.triare.p111weather.api.WeatherService
import com.triare.p111weather.model.WeatherDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val _weatherResult = MutableLiveData<WeatherDto>()
    val weatherResult: LiveData<WeatherDto> = _weatherResult

    init {
        getWeatherCurrent()
        getWeatherHourly()
    }

    private fun getWeatherCurrent() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://weatherbit-v1-mashape.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService = retrofit.create(WeatherService::class.java)

        weatherService.getWeatherCurrent(49.444431f, 32.059769f)
            .enqueue(object : Callback<WeatherDto> {
                override fun onResponse(
                    call: Call<WeatherDto>,
                    response: Response<WeatherDto>
                ) {
                    _weatherResult.value = response.body()
                }

                override fun onFailure(call: Call<WeatherDto>, t: Throwable) {
                }
            })
    }

    private fun getWeatherHourly() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://weatherbit-v1-mashape.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService = retrofit.create(WeatherService::class.java)

        weatherService.getWeatherCurrent(49.444431f, 32.059769f)
            .enqueue(object : Callback<WeatherDto> {
                override fun onResponse(
                    call: Call<WeatherDto>,
                    response: Response<WeatherDto>
                ) {
                    _weatherResult.value = response.body()
                }

                override fun onFailure(call: Call<WeatherDto>, t: Throwable) {
                }
            })
    }
}