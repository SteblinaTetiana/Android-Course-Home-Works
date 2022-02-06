package com.triare.p121quakealert.ui.quakealertlist

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triare.p121quakealert.Magnitude.Companion.getMagnitude
import com.triare.p121quakealert.R
import com.triare.p121quakealert.ui.model.FeatureDvo
import com.triare.p121quakealert.utils.TimeUtils
import java.util.*

class QuakeAlertAdapter(
    var features: List<FeatureDvo> = emptyList(),
    val clickListener: OnItemClickListener
) :
    RecyclerView.Adapter<QuakeAlertAdapter.QuakeAlertViewHolder>() {

    interface OnItemClickListener {
        fun onClick(feature: FeatureDvo)
    }

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

    inner class QuakeAlertViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        init {
            view.setOnClickListener(this)
        }

        private val time = view.findViewById<TextView>(R.id.time)
        private val locality = view.findViewById<TextView>(R.id.locality)
        private val intensity = view.findViewById<TextView>(R.id.intensity)
        private val magnitude = view.findViewById<TextView>(R.id.magnitude)

        fun bind(features: FeatureDvo) {
            initTime(features)
            initLocality(features)
            initIntensity(features)
            initMagnitude(features)
        }

        private fun initTime(features: FeatureDvo) {
            val timeStr = features.properties.time
            if (timeStr != null) {
                val date = TimeUtils.parseTime(timeStr)
                date?.let {
                    val niceDateStr: String = DateUtils.getRelativeTimeSpanString(
                        date,
                        Calendar.getInstance().timeInMillis,
                        DateUtils.DAY_IN_MILLIS
                    ) as String
                    time.text = niceDateStr
                }
            }
        }

        private fun initLocality(features: FeatureDvo) {
            locality?.text = features.properties.locality
        }

        private fun initIntensity(features: FeatureDvo) {
            val magnitude = getMagnitude(features.properties.magnitude)
            intensity?.setText(magnitude.title)
            intensity?.setBackgroundResource(magnitude.color)
        }

        private fun initMagnitude(features: FeatureDvo) {
            this.magnitude?.text = String.format(
                "%.1f",
                features.properties.magnitude
            )
        }

        override fun onClick(v: View?) {
            clickListener.onClick(features[adapterPosition])
        }
    }
}