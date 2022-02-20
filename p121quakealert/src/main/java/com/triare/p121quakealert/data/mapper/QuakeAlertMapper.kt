package com.triare.p121quakealert.data.mapper

import com.triare.p121quakealert.data.model.QuakeAlertDto
import com.triare.p121quakealert.ui.model.FeatureDvo
import com.triare.p121quakealert.ui.model.GeometryDvo
import com.triare.p121quakealert.ui.model.PropertiesDvo
import com.triare.p121quakealert.ui.model.QuakeAlertDvo

class QuakeAlertMapper(private val quakeAlertDto: QuakeAlertDto) {

    fun map(): QuakeAlertDvo {
        val features = quakeAlertDto.features.map {
            val geometry = GeometryDvo(
                it.geometry.coordinates,
                it.geometry.type
            )
            val properties = PropertiesDvo(
                it.properties.depth,
                it.properties.locality,
                it.properties.magnitude,
                it.properties.time
            )
            FeatureDvo(
                geometry,
                it.type,
                properties
            )
        }
        return QuakeAlertDvo(features, quakeAlertDto.type)
    }
}