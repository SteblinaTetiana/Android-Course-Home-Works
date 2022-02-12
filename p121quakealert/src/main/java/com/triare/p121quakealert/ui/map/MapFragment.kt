package com.triare.p121quakealert.ui.map

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.triare.p121quakealert.R
import com.triare.p121quakealert.utils.PlaceMarker


class MapFragment : Fragment(), OnMapReadyCallback {

    companion object {
        fun newInstance() = MapFragment()
    }

    private lateinit var viewModel: MapViewModel
    private lateinit var mMap: GoogleMap
    private lateinit var marker: List<PlaceMarker>
    private val startForPermissionResult = buildRegisterForPermissionResult()

    private fun buildRegisterForPermissionResult(): ActivityResultLauncher<Array<String>> {
        return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            result[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MapViewModel::class.java]

        setUpMapIfNeeded()
        checkPermissionLocation()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    private fun setUpMapIfNeeded() {
        val mapFragment =
            this.childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }


    @SuppressLint("MissingPermission")
    private fun setUpMap(googleMap: GoogleMap) {
        mMap = googleMap
        if (checkPermissionLocation() != null) {
            mMap.isMyLocationEnabled = true
        }
        mMap.addMarker(
            MarkerOptions().position(LatLng(49.409225, 32.030689)).title("Marker")
        )
        mMap.moveCamera(
            CameraUpdateFactory.newCameraPosition(
                CameraPosition.fromLatLngZoom(
                    LatLng(49.409225, 32.030689),
                    15f
                )
            )
        )
    }

    private fun checkPermissionLocation() {
        startForPermissionResult.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        setUpMap(mMap)
    }
}