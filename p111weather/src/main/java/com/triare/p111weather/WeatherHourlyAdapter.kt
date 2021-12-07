package com.triare.p111weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.triare.p111weather.model.Data
import com.triare.p111weather.model.WeatherDto
import kotlin.math.roundToInt

class WeatherHourlyAdapter(private val weatherDto: WeatherDto?) :
    RecyclerView.Adapter<WeatherHourlyAdapter.WeatherHourlyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHourlyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_weather, parent, false)
        return WeatherHourlyViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherHourlyViewHolder, position: Int) {
        val weather = weatherDto?.data?.get(position)
        if (weather != null) {
            weatherDto?.let { holder.bind(it, weather) }
        }
    }

    override fun getItemCount(): Int {
        return weatherDto?.data?.size ?: 0
    }

    inner class WeatherHourlyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon = itemView.findViewById<ImageView>(R.id.icon)
        private val temperature = itemView.findViewById<TextView>(R.id.temperature)
        private val time = itemView.findViewById<TextView>(R.id.time)

        fun bind(
            weatherDto: WeatherDto,
            data: Data
        ) {
            time.text = weatherDto.timezone
            temperature.text =
                String.format("%d \u00B0" + "C", data.temp.roundToInt())
            icon?.let {
                Glide.with(itemView.context)
                    .asBitmap()
                    .circleCrop()
                    .load(IMG_URL + data.weather.icon + ".png")
                    .into(icon)
            }
        }
    }
}