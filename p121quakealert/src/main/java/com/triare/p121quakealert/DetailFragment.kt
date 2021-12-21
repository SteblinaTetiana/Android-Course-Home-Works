package com.triare.p121quakealert

import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.triare.p121quakealert.model.Feature
import com.triare.p121quakealert.model.Properties
import java.text.SimpleDateFormat
import java.util.*


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val properties = arguments?.getSerializable(QUAKE_ALERT_POS) as Properties?

        bind(properties)
    }

    private fun bind(properties: Properties?) {
        val detailTime = view?.findViewById<TextView>(R.id.detail_time)
        val detailDepth = view?.findViewById<TextView>(R.id.detail_depth)
        val detailIntensity = view?.findViewById<TextView>(R.id.detail_intensity)
        val detailMagnitude = view?.findViewById<TextView>(R.id.detail_magnitude)

        if (properties?.time != null) {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            var dateStr = properties.time
            var date = inputFormat.parse(dateStr)
            var niceDateStr: String = DateUtils.getRelativeTimeSpanString(
                date.time,
                Calendar.getInstance().timeInMillis,
                DateUtils.DAY_IN_MILLIS
            ) as String
            detailTime?.text = niceDateStr
        }

        detailDepth?.text = String.format(
            "Відстань до епіцентру: %.1f" + " км",
            properties?.depth
        )
        /*   detailIntensity?.text = String.format(
               "%s",
               *//*  dvo?.title, dvo?.color*//*
    )*/
        detailMagnitude?.text = String.format(
            "%.1f",
            properties?.magnitude
        )
    }

    companion object {
        fun newInstance(features: Feature): DetailFragment =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(QUAKE_ALERT_POS, features)
                }
            }
    }
}

const val QUAKE_ALERT_POS =
    "com.triare.p121quakealert.quakealertlist.QuakeAlertListFragmentPosition"