package com.triare.p121quakealert.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.triare.p121quakealert.Magnitude
import com.triare.p121quakealert.utils.MapHelper.context

class ClusterMarkerRenderer(
    context: Context,
    map: GoogleMap,
    clusterManager: ClusterManager<PlaceMarker>
) :
    DefaultClusterRenderer<PlaceMarker>(context, map, clusterManager),
    ClusterManager.OnClusterClickListener<PlaceMarker> {

    private val googleMap: GoogleMap = map

    init {
        clusterManager.setOnClusterClickListener(this)
        googleMap.setOnCameraIdleListener(clusterManager)
        googleMap.setOnMarkerClickListener(clusterManager)
    }

    override fun onBeforeClusterItemRendered(item: PlaceMarker, markerOptions: MarkerOptions) {
        super.onBeforeClusterItemRendered(item, markerOptions)
        val magnitude = Magnitude.getMagnitude(MapHelper.features.properties.magnitude)
        val icon = MapHelper.vectorToBitmap(context, magnitude.icon)
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon as Bitmap))
        markerOptions.title(item.title)
    }

    override fun onClusterClick(cluster: Cluster<PlaceMarker>): Boolean {
        val bounds = MapHelper.setUpBounds(cluster.items)
        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 150))
        return true
    }

    override fun getColor(clusterSize: Int): Int {
        return Color.parseColor("#ffa000")
    }
}