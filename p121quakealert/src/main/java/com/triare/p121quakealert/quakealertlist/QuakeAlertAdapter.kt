package com.triare.p121quakealert.quakealertlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triare.p121quakealert.R
import com.triare.p121quakealert.model.Feature
import com.triare.p121quakealert.model.Properties
import java.text.SimpleDateFormat

class QuakeAlertAdapter(var features: List<Feature>):RecyclerView.Adapter<QuakeAlertAdapter.QuakeAlertViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuakeAlertViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return QuakeAlertViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuakeAlertViewHolder, position: Int) {
        val properties = features[position]
        if (properties != null) {
            features.let { holder.bind(it) }
        }
    }

    override fun getItemCount(): Int {
        return features.size ?: 0
    }

    inner class QuakeAlertViewHolder(view:View):RecyclerView.ViewHolder(view) {

        private val time = view.findViewById<TextView>(R.id.time)
        private val locality = view.findViewById<TextView>(R.id.locality)
        private val intensity = view.findViewById<TextView>(R.id.intensity)
        private val magnitude = view.findViewById<TextView>(R.id.magnitude)

        fun bind(
            features: List<Feature>
        ) {
            if (features.get(0).properties.time != null) {
                val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                val formatter = SimpleDateFormat("dd.MM.yyyy")
                val output: String = formatter.format(parser.parse(features.get(0).properties.time))
                time.text = output
            }
            locality?.text = features[0].properties.locality
         /*   intensity?.text = properties.magnitude
            magnitude?.text = properties.magnitude*/
        }


    }

}