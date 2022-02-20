package com.triare.p121quakealert.utils

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

class PlaceMarker(lat: Double, lng: Double, title: String) : ClusterItem {
    private val mPosition: LatLng = LatLng(lat, lng)
    private val mTitle: String = title
    private val mSnippet: String = ""

    override fun getPosition(): LatLng {
        return mPosition
    }

    override fun getTitle(): String {
        return mTitle
    }

    override fun getSnippet(): String {
        return mSnippet
    }
}