package com.triare.p121quakealert.quakealertlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triare.p121quakealert.R
import com.triare.p121quakealert.model.Feature
import java.text.SimpleDateFormat
import kotlin.math.roundToInt

class QuakeAlertAdapter(var features: List<Feature>) :
    RecyclerView.Adapter<QuakeAlertAdapter.QuakeAlertViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuakeAlertViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return QuakeAlertViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuakeAlertViewHolder, position: Int) {
        features[position].let { holder.bind(it) }

    }

    override fun getItemCount(): Int {
        return features.size
    }

    inner class QuakeAlertViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val time = view.findViewById<TextView>(R.id.time)
        private val locality = view.findViewById<TextView>(R.id.locality)
        private val intensity = view.findViewById<TextView>(R.id.intensity)
        private val magnitude = view.findViewById<TextView>(R.id.magnitude)

        fun bind(
            features: Feature
        ) {
            if (features.properties.time != null) {
                val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                val formatter = SimpleDateFormat("dd.MM.yyyy")
                val output: String = formatter.format(parser.parse(features.properties.time))
                time.text = output
            }
            locality?.text = features.properties.locality
            intensity?.text = String.format(
                "%d",
                features.properties.magnitude.roundToInt()
            )
            magnitude?.text = String.format(
                "%.1f",
                features.properties.magnitude
            )
        }
    }
}