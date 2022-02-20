package com.triare.p121quakealert.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.algo.GridBasedAlgorithm
import com.triare.p121quakealert.Magnitude
import com.triare.p121quakealert.ui.model.FeatureDvo
import com.triare.p121quakealert.ui.model.Features

@SuppressLint("StaticFieldLeak")
object MapHelper {

    lateinit var context: Context
    lateinit var features: FeatureDvo
    private lateinit var mMap: GoogleMap
    private var locationArrayList: ArrayList<LatLng>? = null
    private lateinit var builder: LatLngBounds.Builder


    private fun getPosition(features: FeatureDvo): LatLng {
        val lat = features.geometry.coordinates.first()
        val lng = features.geometry.coordinates.last()
        return LatLng(lat, lng)
    }

    /* private val magnitudeIcon by lazy {
         BitmapFactory.decodeResource(
             context.resources,
             R.drawable.ic_magnitude_average
         )
     }*/

    private val magnitudeIcon: BitmapDescriptor by lazy {
        val magnitude = Magnitude.getMagnitude(features.properties.magnitude)
        vectorToBitmap(context, magnitude.icon)
    }

    fun init(context: Context) {
        this.context = context
    }

    fun setUpCamera(googleMap: GoogleMap, cameraUpdate: CameraUpdate) {
        googleMap.moveCamera(cameraUpdate)
    }

    fun setUpBounds(markerList: MutableIterable<PlaceMarker>): LatLngBounds {
        builder = LatLngBounds.builder()
        for (marker in markerList) {
            builder.include(marker.position)
        }
        return builder.build()
    }

    fun updateCameraZoom(markerList: ArrayList<PlaceMarker>): CameraUpdate {
        return CameraUpdateFactory.newLatLngZoom(
            markerList[0].position,
            16.0f
        )
    }

    fun updateCameraBounds(markerList: ArrayList<PlaceMarker>): CameraUpdate {
        return CameraUpdateFactory.newLatLngBounds(
            setUpBounds(markerList), 150
        )
    }

    fun setUpClusterOfMarkers(
        googleMap: GoogleMap,
        markerList: ArrayList<PlaceMarker>,
        context: Context
    ): ClusterManager<PlaceMarker> {
        val manager = ClusterManager<PlaceMarker>(context, googleMap)
        manager.renderer = ClusterMarkerRenderer(context, googleMap, manager)
        manager.algorithm = GridBasedAlgorithm()
        manager.addItems(markerList)
        manager.cluster()
        return manager
    }

    fun getMarkerList(features: Features): ArrayList<PlaceMarker> {
        val placeMarkerList = ArrayList<PlaceMarker>()
        for (place in features) {
            val mItem =
                PlaceMarker(
                    getPosition(place).longitude,
                    getPosition(place).longitude,
                    place.properties.locality
                )
            placeMarkerList.add(mItem)
        }
        return placeMarkerList
    }

    fun setUpMarker(marker: PlaceMarker, googleMap: GoogleMap /*, features: FeatureDvo*/) {
        mMap = googleMap
        /*   val coordinates = features.geometry.coordinates

           *//*locationArrayList = ArrayList()*//*
        locationArrayList!!.add(
            LatLng(coordinates.first(), coordinates.last())
        )

        for (i in locationArrayList!!.indices) {
            mMap.addMarker(MarkerOptions().position(locationArrayList!![i]).title("Marker").icon(magnitudeIcon))

            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f))

            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!![i]))
        }*/

        googleMap.addMarker(
            markerOptions(marker)
        )

        /* for (location in coordinates) {
             val latLng = LatLng(location, location)
             mMap.addMarker(
                 MarkerOptions()
                     .position(latLng)
                     .title("")
                     .icon(magnitudeIcon)
             )
         }*/

    }

    fun markerOptions(marker: PlaceMarker): MarkerOptions {
        return MarkerOptions()
            .position(marker.position)
            .title(marker.title)
            .icon(magnitudeIcon)
    }

    fun vectorToBitmap(context: Context, @DrawableRes id: Int): BitmapDescriptor {
        val vectorDrawable = ResourcesCompat.getDrawable(context.resources, id, null)
        if (vectorDrawable == null) {
            Log.e("BitmapHelper", "Resource not found")
            return BitmapDescriptorFactory.defaultMarker()
        }
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

}