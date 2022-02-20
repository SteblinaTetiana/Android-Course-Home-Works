package com.triare.p121quakealert.ui.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.triare.p121quakealert.R

private const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1

class MapFragment : Fragment(), OnMapReadyCallback {

    private val args by navArgs<MapFragmentArgs>()

    private val viewModel by viewModels<MapViewModel>()

    private lateinit var mMap: GoogleMap
    private val startForPermissionResult = buildRegisterForPermissionResult()
    private var locationPermissionGranted = false
    private var lastKnownLocation: Location? = null
    /*private lateinit var features: FeatureDvo*/


    private fun buildRegisterForPermissionResult(): ActivityResultLauncher<Array<String>> {
        return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            result[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkPermissionLocation()
        initMap()
        observeUpdate()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        args.features?.let { viewModel.init(it) }
    }


    private fun checkPermissionLocation() {
        startForPermissionResult.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
        getLocationPermission()
    }

    private fun getLocationPermission() {
        if (activity?.let {
                ContextCompat.checkSelfPermission(
                    it.applicationContext,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            }
            == PackageManager.PERMISSION_GRANTED) {
            locationPermissionGranted = true
        } else {
            activity?.let {
                ActivityCompat.requestPermissions(
                    it, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
                )
            }
        }
    }


    private fun initMap() {
        val mapFragment =
            this.childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }

    private fun observeUpdate() {
        viewModel.featuresResult.observe(viewLifecycleOwner) {
            args.features?.let { viewModel.createMarker(mMap, it) }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        updateLocationUI()
        args.features?.let { viewModel.createMarker(mMap, it) }

        /*val gmmIntentUri = Uri.parse("$coordinates")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)*/
    }

    @SuppressLint("MissingPermission")
    private fun updateLocationUI(): Boolean {
        if (mMap == null) {
            return false
        }
        try {
            if (locationPermissionGranted) {
                mMap.isMyLocationEnabled = true
                mMap.uiSettings.isMyLocationButtonEnabled = true
            } else {
                mMap.isMyLocationEnabled = false
                mMap.uiSettings.isMyLocationButtonEnabled = false
                lastKnownLocation = null
                getLocationPermission()
            }
        } catch (e: SecurityException) {
            e.message?.let { Log.e("Exception: %s", it) }
        }
        return true
    }


/* coordinates.let {
     it?.forEach { coordinates ->
         googleMap.addMarker(
             MarkerOptions().position(
                 LatLng(it.first(), it.last())
             )
         )
     }
     it?.first().let { coordinates ->
         it?.last()?.let { it1 -> LatLng(it.first(), it1) }?.let { it2 ->
             CameraUpdateFactory.newLatLngZoom(
                 it2, 3F
             )
         }?.let { it3 ->
             googleMap.moveCamera(
                 it3
             )
         }
     }
 }
}*/

/*if (coordinates != null) {
    for (place in coordinates) {

        val marker = mMap.addMarker(
            MarkerOptions().position(
                LatLng(
                    coordinates.first(),
                    coordinates.last()
                )
            )
                .title("")
            *//*  .icon(bicycleIcon)*//*
                )
                marker?.let { feature.add(it) }

                mMap.moveCamera(
                    CameraUpdateFactory.newCameraPosition(
                        CameraPosition.fromLatLngZoom(
                            LatLng(
                                coordinates.first(),
                                coordinates.last()
                            ),
                            15f
                        )
                    )
                )
            }
        }
*/
}
