package com.example.parcial3final

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnSuccessListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapFragment : SupportMapFragment(), OnMapReadyCallback, OnSuccessListener<Location> {

    private lateinit var map : GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        getMapAsync(this)
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(location: GoogleMap) {
        this.map = location
        fusedLocationClient.lastLocation.addOnSuccessListener(this)
    }

    override fun onSuccess(p0: Location?) {

        if (p0 != null) {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(p0.latitude,p0.longitude),15f))
            map.addMarker(MarkerOptions().position(LatLng(p0.latitude,p0.longitude)))
            map.addMarker(MarkerOptions().position(LatLng(4.7563171,-74.1106713)))
            map.addMarker(MarkerOptions().position(LatLng(4.7519623,-74.1094423)))
            map.addMarker(MarkerOptions().position(LatLng(4.7517355,-74.1107927)))
            map.addMarker(MarkerOptions().position(LatLng(4.7547748,-74.1127803)))
        }
    }
}