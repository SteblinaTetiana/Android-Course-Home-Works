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
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.algo.GridBasedAlgorithm
import com.triare.p121quakealert.Magnitude
import com.triare.p121quakealert.ui.model.FeatureDvo
import com.triare.p121quakealert.ui.model.Features

@SuppressLint("StaticFieldLeak")
object MapHelper {

    private lateinit var context: Context
    private lateinit var features: FeatureDvo
    private lateinit var mMap: GoogleMap
    private var locationArrayList: ArrayList<LatLng>? = null


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

    fun updateCameraZoom(markerList: ArrayList<PlaceMarker>): CameraUpdate {
        return CameraUpdateFactory.newLatLngZoom(
            markerList[0].position,
            16.0f
        )
    }
/*
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
      }*/

    fun getMarkerList(features: Features): ArrayList<PlaceMarker> {
        val placeMarkerList = ArrayList<PlaceMarker>()
        for (place in features) {
            val mItem =
                PlaceMarker(
                    getPosition(place).latitude,
                    getPosition(place).longitude,
                    place.properties.locality
                )
            placeMarkerList.add(mItem)
        }
        return placeMarkerList
    }

    fun setUpMarker(googleMap: GoogleMap, marker: PlaceMarker, features: FeatureDvo) {

        val coordinates = features.geometry.coordinates

        locationArrayList = ArrayList()
        locationArrayList!!.add(
            LatLng(coordinates.first(), coordinates.last())
        )

        if (locationArrayList != null) {
            for (i in 0 until locationArrayList!!.size) {
                if (locationArrayList != null) {
                    mMap.addMarker(MarkerOptions().position(locationArrayList!![i]).title("Marker")
                        .icon(magnitudeIcon))
                    /* mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f))
                     mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!![i]))*/
                }
            }
        }
        mMap = googleMap
         googleMap.addMarker(
             markerOptions(marker)
         )

        /*for (location in features.geometry.coordinates) {
            val latLng = LatLng(location, location)
            mMap.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title("")
                   *//* .icon(magnitudeIcon)*//*
            )
        }*/

    }

    fun markerOptions(marker: PlaceMarker): MarkerOptions {
        return MarkerOptions()
            .position(marker.position)
            .title(marker.title)
             .icon(magnitudeIcon)
    }

/*    private fun resizeBitmap(bitmap: Bitmap): Bitmap = Bitmap.createScaledBitmap(bitmap, 63, 110, false)

private fun createMarker(text: String, bitmap: Bitmap): Bitmap {
val mBitmap = resizeBitmap(bitmap)
val canvas = Canvas(mBitmap)
val paint = Paint()
paint.textSize = 40F
paint.style = Paint.Style.FILL
canvas.drawText(
   text,
   (mBitmap.width / 3).toFloat(),
   (mBitmap.height / 2).toFloat(),
   paint
)
return mBitmap
}*/


    private fun vectorToBitmap(context: Context, @DrawableRes id: Int): BitmapDescriptor {
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