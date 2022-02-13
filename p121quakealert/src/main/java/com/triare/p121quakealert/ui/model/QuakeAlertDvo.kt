package com.triare.p121quakealert.ui.model

import com.google.android.gms.maps.model.LatLng
import com.triare.p121quakealert.utils.PlaceMarker
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

/*data class CoordinatesDvo(
    val lat: Double,
    val lng: Double
)*/

data class PropertiesDvo(
    val depth: Double,
    val locality: String,
    val magnitude: Double,
    val time: String
)

/*
fun FeatureDvo.toPlaceMarker(): PlaceMarker = PlaceMarker(
    name = "",
    latLng = LatLng(geometry.coordinates.lat, geometry.coordinates.lng),
    address = "",
)
*/

class Features: ArrayList<FeatureDvo>()
