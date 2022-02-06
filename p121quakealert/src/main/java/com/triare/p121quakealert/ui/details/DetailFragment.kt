package com.triare.p121quakealert.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.triare.p121quakealert.Magnitude
import com.triare.p121quakealert.R
import com.triare.p121quakealert.utils.TimeUtils
import java.util.*


class DetailFragment : Fragment() {

    private val featuresArgs by navArgs<DetailFragmentArgs>()

    private var detailTime: TextView? = null
    private var detailDepth: TextView? = null
    private var detailIntensity: TextView? = null
    private var detailMagnitude: TextView? = null

    private fun getMagnitude(): Magnitude {
        val magnitude = featuresArgs.features?.properties
        return magnitude.let { Magnitude.getMagnitude(it!!.magnitude) }
    }

    private fun getTime(): String? {
        return featuresArgs.features?.properties?.time
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi(view)
    }

    private fun initUi(view: View) {
        initViews(view)
        initTime()
        initDetailDepth()
        initDetailIntensity()
        initDetailMagnitude()
    }

    private fun initViews(view: View) {
        detailTime = view.findViewById(R.id.detail_time)
        detailDepth = view.findViewById(R.id.detail_depth)
        detailIntensity = view.findViewById(R.id.detail_intensity)
        detailMagnitude = view.findViewById(R.id.detail_magnitude)
    }

    private fun initTime() {
        val time = getTime()
        if (time != null) {
            val formattedTime = TimeUtils.parseTime(time)
            formattedTime?.let {
                val niceDateStr: String = DateUtils.getRelativeTimeSpanString(
                    formattedTime,
                    Calendar.getInstance().timeInMillis,
                    DateUtils.DAY_IN_MILLIS
                ) as String
                detailTime?.text = niceDateStr
            }
        }
    }

    @SuppressLint("StringFormatMatches")
    private fun initDetailDepth() {
        val depth = featuresArgs.features?.properties?.depth ?: 0
        detailDepth?.text = getString(
            R.string.distance_to_epicenter_format,
            depth
        )
    }

    private fun initDetailIntensity() {
        val magnitude = getMagnitude()
        magnitude.title.let { detailIntensity?.setText(it) }
        magnitude.color.let { detailIntensity?.setBackgroundResource(it) }
    }

    @SuppressLint("StringFormatMatches")
    private fun initDetailMagnitude() {
        val detailMagnitude = featuresArgs.features?.properties?.magnitude ?: 0
        this.detailMagnitude?.text = getString(
            R.string.magnitude_format,
            detailMagnitude
        )
    }
}