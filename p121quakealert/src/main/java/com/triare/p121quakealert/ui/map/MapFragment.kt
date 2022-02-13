package com.triare.p121quakealert.ui.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.triare.p121quakealert.R
import com.google.android.gms.maps.model.LatLng
import com.triare.p121quakealert.ui.model.FeatureDvo
import com.triare.p121quakealert.ui.model.Features
import com.google.android.gms.maps.CameraUpdateFactory

import com.google.android.gms.maps.model.MarkerOptions





class MapFragment : Fragment(), OnMapReadyCallback {

    private val args: MapFragmentArgs by navArgs()
   /* private lateinit var viewModel: MapViewModel*/
    private val viewModel: MapViewModel by viewModels()
    private lateinit var mMap: GoogleMap
    private val startForPermissionResult = buildRegisterForPermissionResult()
    private var locationArrayList: ArrayList<LatLng>? = null
    private lateinit var features: FeatureDvo

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

    /*override fun onAttach(context: Context) {
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

      /*  for (i in locationArrayList!!.indices) {

            // below line is use to add marker to each location of our array list.
            mMap.addMarker(MarkerOptions().position(locationArrayList!![i]).title("Marker"))

            // below lin is use to zoom our camera on map.
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f))

            // below line is use to move our camera to the specific location.
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!![i]))
        }*/
        viewModel.setUpMarker(mMap)

    }


}