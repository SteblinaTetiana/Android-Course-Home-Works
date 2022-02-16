package com.triare.p121quakealert.ui.model

import java.io.Serializable

data class QuakeAlertDvo(
    val features: List<FeatureDvo>,
    val type: String
)

data class FeatureDvo(
    val geometry: GeometryDvo,
    val type: String,
    val properties: PropertiesDvo
) : Serializable

data class GeometryDvo(
    val coordinates: List<Double>,
    val type: String
)

data class PropertiesDvo(
    val depth: Double,
    val locality: String,
    val magnitude: Double,
    val time: String
)

class Features : ArrayList<FeatureDvo>()