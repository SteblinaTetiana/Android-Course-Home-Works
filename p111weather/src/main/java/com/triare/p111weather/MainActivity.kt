package com.triare.p111weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.triare.p111weather.model.WeatherDto
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    /*private val viewModel by viewModels<MainViewModel>()*/
    private var viewModel: MainViewModel? = null

    private var date: TextView? = null
    private var icon: ImageView? = null
    private var temperature: TextView? = null
    private var tempFeelsLike: TextView? = null
    private var description: TextView? = null
    private var windSpd: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()

        viewModel?.weatherResult?.observe(this) {
            renderWeatherCurrent(it)
        }
    }

    private fun initUI() {
        date = findViewById(R.id.date)
        icon = findViewById(R.id.icon)
        temperature = findViewById(R.id.temperature)
        tempFeelsLike = findViewById(R.id.temp_feels_like)
        description = findViewById(R.id.description)
        windSpd = findViewById(R.id.wind_spd)
    }

    private fun renderWeatherCurrent(weatherDto: WeatherDto) {
        date?.text = weatherDto.data[0].datetime
        icon?.let {
            Glide.with(this.applicationContext)
                .asBitmap()
                .circleCrop()
                .load(IMG_URL + weatherDto.data[0].weather.icon + ".png")
                .into(icon!!)
        }
        temperature?.text = String.format("%d \u00B0" + "C", weatherDto.data[0].temp.roundToInt())
        tempFeelsLike?.text = String.format(
            "відчувається як %d \u00B0" + "C",
            weatherDto.data[0].temp.roundToInt(),
            weatherDto.data[0].temp.roundToInt(),
            weatherDto.data[0].temp.roundToInt()
        )
        description?.text = weatherDto.data[0].weather.description
        windSpd?.text = String.format(
            "Вітер: %.2f" + " км/год, ",
            weatherDto.data[0].windSpd,
            weatherDto.data[0].windCdirFull
        )
    }
}