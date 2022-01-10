package com.triare.p121quakealert

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.triare.p121quakealert.quakealertlist.QuakeAlertAdapter
import java.text.SimpleDateFormat
import java.util.*


class DetailFragment : Fragment() {

    private val featuresArgs by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailTime = view.findViewById<TextView>(R.id.detail_time)
        val detailDepth = view.findViewById<TextView>(R.id.detail_depth)
        val detailIntensity = view.findViewById<TextView>(R.id.detail_intensity)
        val detailMagnitude = view.findViewById<TextView>(R.id.detail_magnitude)
        val dvo =
            featuresArgs.features?.properties?.let { QuakeAlertAdapter.initMagnitude(it.magnitude) }
        if (featuresArgs.features?.properties?.time != null) {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            val dateStr = featuresArgs.features?.properties?.time
            val date = inputFormat.parse(dateStr)
            val niceDateStr: String = DateUtils.getRelativeTimeSpanString(
                date.time,
                Calendar.getInstance().timeInMillis,
                DateUtils.DAY_IN_MILLIS
            ) as String
            detailTime?.text = niceDateStr
        }
        detailDepth?.text = String.format(
            "Відстань до епіцентру: %.1f" + " км",
            featuresArgs.features?.properties?.depth
        )
        detailIntensity?.text = dvo?.title.toString()
        dvo?.color?.let { detailIntensity?.setBackgroundResource(it) }
        detailMagnitude?.text = String.format(
            "%.1f",
            featuresArgs.features?.properties?.magnitude
        )
    }
}