package com.triare.p121quakealert.ui.map

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.GoogleMap
import com.google.maps.android.clustering.ClusterManager
import com.triare.p121quakealert.data.repository.QuakeAlertRepository
import com.triare.p121quakealert.ui.model.FeatureDvo
import com.triare.p121quakealert.ui.model.Features
import com.triare.p121quakealert.utils.MapHelper
import com.triare.p121quakealert.utils.MapHelper.context
import com.triare.p121quakealert.utils.MapHelper.getMarkerList
import com.triare.p121quakealert.utils.PlaceMarker

class MapViewModel : ViewModel() {

    private lateinit var mMap: GoogleMap
    
    private val quakeAlertRepository = QuakeAlertRepository()
    private lateinit var _features: Features
    private lateinit var clusterManager: ClusterManager<PlaceMarker>

    private val _featuresResult = MutableLiveData<List<FeatureDvo>>()
    val featuresResult: LiveData<List<FeatureDvo>> = _featuresResult

    fun init(features: Features) {
        _features = features
    }

    init {
        getQuakeAlert()
    }

    @SuppressLint("MissingPermission")
    fun createMarker(googleMap: GoogleMap, features: Features) {
        mMap = googleMap
        _features = features

        /*   mMap.let { MapHelper.setUpMarker(mMap, *//*it, *//**//*features*//*) }*/
        val markersList = getMarkerList(_features)
        clusterManager = MapHelper.setUpClusterOfMarkers(mMap, markersList, context)
        markersList.forEach { placeMarker ->
            MapHelper.setUpMarker(placeMarker, mMap)
        }

        val updateCamera =
            if (markersList.toList().size == 1) {
                MapHelper.updateCameraZoom(markersList)
            } else {
                MapHelper.updateCameraBounds(markersList)
            }

        MapHelper.setUpCamera(mMap, updateCamera as CameraUpdate)
    }

    fun onInfoWindowClick(navController: NavController) {
        clusterManager.setOnClusterItemInfoWindowClickListener { placeMarker ->
            _features.forEach { feature ->
                if (feature.properties.locality == placeMarker.title) {
                    MapFragmentDirections.actionMapFragmentToDetailFragment(
                        feature
                    ).also {
                        navController.navigate(it)
                    }
                }
            }
        }
    }


    private fun getQuakeAlert() {
        quakeAlertRepository.getQuakeAlert {
            _featuresResult.value = it.features
        }
    }
}