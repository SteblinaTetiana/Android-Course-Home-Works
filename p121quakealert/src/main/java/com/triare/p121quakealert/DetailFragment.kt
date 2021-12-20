package com.triare.p121quakealert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.triare.p121quakealert.model.Properties
import java.text.SimpleDateFormat


class DetailFragment : Fragment() {

    private var properties: Properties? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        properties?.let { bind(it) }
    }

    private fun bind(properties: Properties){
        val detailTime = view?.findViewById<TextView>(R.id.detail_time)
        val detailDepth = view?.findViewById<TextView>(R.id.detail_depth)
        val detailIntensity = view?.findViewById<TextView>(R.id.detail_intensity)
        val detailMagnitude = view?.findViewById<TextView>(R.id.detail_magnitude)


        if (properties.time != null) {
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val formatter = SimpleDateFormat("dd.MM.yyyy")
            val output: String = formatter.format(parser.parse(properties.time))
            detailTime?.text = output
        }
        detailDepth?.text = String.format(
            "Вітер: %.2f" + " км/год",
           properties.depth
        )
     /*   detailIntensity?.text = String.format(
            "%s",
            *//*  dvo?.title, dvo?.color*//*
        )*/
        detailMagnitude?.text = String.format(
            "%.1f",
            properties.magnitude
        )
    }
}