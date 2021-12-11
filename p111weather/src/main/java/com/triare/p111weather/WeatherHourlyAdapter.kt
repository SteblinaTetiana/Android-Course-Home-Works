package com.triare.p111weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.triare.p111weather.model.Data
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

class WeatherHourlyAdapter(var data: List<Data>) :
    RecyclerView.Adapter<WeatherHourlyAdapter.WeatherHourlyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHourlyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_weather, parent, false)
        return WeatherHourlyViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherHourlyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class WeatherHourlyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon = itemView.findViewById<ImageView>(R.id.icon)
        private val temperature = itemView.findViewById<TextView>(R.id.temperature_hourly)
        private val time = itemView.findViewById<TextView>(R.id.time)

        fun bind(
            data: Data
        ) {
            val localDateTime: LocalDateTime = LocalDateTime.parse(data.timestampLocal)
            val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")
            val output: String = formatter.format(localDateTime)
            time?.text = output
            temperature?.text =
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