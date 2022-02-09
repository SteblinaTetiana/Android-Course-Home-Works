package com.triare.p121quakealert.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.triare.p121quakealert.R
import com.triare.p121quakealert.ui.model.GeometryDvo


class MapFragment : Fragment(), OnMapReadyCallback {

    companion object {
        fun newInstance() = MapFragment()
    }

    private lateinit var viewModel: MapViewModel
    private lateinit var mMap: GoogleMap
    private lateinit var geometry: List<GeometryDvo>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MapViewModel::class.java]

        val mapFragment =
            this.activity!!.supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    private fun addMarkers(googleMap: GoogleMap) {
        geometry.forEach { geometry ->
            /* val marker = googleMap.addMarker(
                MarkerOptions()
                    .position(geometry.coordinates)
            )*/
        }
    }

    override fun onMapReady(p0: GoogleMap) {
        TODO("Not yet implemented")
    }
}