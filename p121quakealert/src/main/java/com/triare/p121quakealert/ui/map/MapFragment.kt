package com.triare.p121quakealert.ui.map

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.triare.p121quakealert.R
import com.triare.p121quakealert.ui.details.DetailFragmentArgs
import com.triare.p121quakealert.ui.model.FeatureDvo


class MapFragment : Fragment(), OnMapReadyCallback {

    private val args by navArgs<MapFragmentArgs>()
    private val feature by lazy { args.features }

    /* private lateinit var viewModel: MapViewModel*/
    private val viewModel: MapViewModel by viewModels()
    private lateinit var mMap: GoogleMap
    private val startForPermissionResult = buildRegisterForPermissionResult()
    /*private lateinit var features: FeatureDvo*/


    private fun buildRegisterForPermissionResult(): ActivityResultLauncher<Array<String>> {
        return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            result[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* viewModel = ViewModelProvider(this)[MapViewModel::class.java]*/

        initMap()
        checkPermissionLocation()

        /*  locationArrayList = ArrayList()
          locationArrayList!!.add(LatLng(features.geometry.coordinates[0], features.geometry.coordinates[0]))*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }
/*
    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.init(args.features)
    }*/


    private fun initMap() {
        val mapFragment =
            this.childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }


    private fun checkPermissionLocation() {
        startForPermissionResult.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }


    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (checkPermissionLocation() != null) {
            mMap.isMyLocationEnabled = true
            mMap.uiSettings.isMyLocationButtonEnabled = true
        }

        val bundle = arguments
        if (bundle == null) {
            Log.e("MapFragment", "MapFragment did not receive marker")
            return
        }
        val args = MapFragmentArgs.fromBundle(bundle)
        args.features?.let { viewModel.setUpMarker(mMap, it) }
    }

       /* if (coordinates != null) {
            mMap.addMarker(
                MarkerOptions().position(
                    LatLng(
                        coordinates.first(),
                        coordinates.last()
                    )
                )
                    .title("")
                *//*   .icon(bicycleIcon)*//*
            )
        }
        if (coordinates != null) {
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
    }*/}
