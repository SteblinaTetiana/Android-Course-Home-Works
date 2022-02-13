package com.triare.p121quakealert.ui.map

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.GoogleMap
import com.triare.p121quakealert.ui.model.Features
import com.triare.p121quakealert.utils.MapHelper

class MapViewModel : ViewModel() {

    private lateinit var mMap: GoogleMap
    /*  private lateinit var placeMarker: PlaceMarker*/
    /*private lateinit var markersList: ArrayList<PlaceMarker>*/
    private lateinit var _features: Features


    fun init(features: Features) {
        _features = features
    }

    @SuppressLint("MissingPermission")
    fun setUpMarker(googleMap: GoogleMap) {
        mMap = googleMap
        /* val updateCamera = MapHelper.updateCameraZoom(markersList)*/
        /*val markersList = getMarkerList(_features)
        val updateCamera =
            if (markersList.toList().size == 1) {
                MapHelper.updateCameraZoom(markersList)
            } else {
              *//*  MapHelper.updateCameraBounds(markersList)*//*
            }
        MapHelper.updateCameraZoom(markersList)
*/
        MapHelper.setUpMarker(mMap/*, placeMarker*/)

        /*      MapHelper.setUpCamera(mMap, updateCamera as CameraUpdate)*/
        /* mMap.addMarker(
             MarkerOptions().position(LatLng(marker.position.latitude, marker.position.longitude))
                 .title("")
                 .icon(bicycleIcon)
         )
         mMap.moveCamera(
             CameraUpdateFactory.newCameraPosition(
                 CameraPosition.fromLatLngZoom(
                     LatLng(49.409225, 32.030689),
                     15f
                 )
             )
         )
     }*/
    }
}