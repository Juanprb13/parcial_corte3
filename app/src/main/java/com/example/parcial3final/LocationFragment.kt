package com.example.parcial3final

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.parcial3final.databinding.FragmentLocationBinding
import com.google.android.gms.location.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LocationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LocationFragment : Fragment() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var binding: FragmentLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate<FragmentLocationBinding>(inflater,R.layout.fragment_location,container,false)

        return binding.root
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationClient =LocationServices.getFusedLocationProviderClient(requireContext())

        // para suscribirme a los cambios de la aplicacion

        //1. location request
        val locationRequest = LocationRequest.create()
        locationRequest.interval = 1000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        //2. Callback
        val locationCallback: LocationCallback = object : LocationCallback() {
            override fun onLocationResult(location: LocationResult) {
                super.onLocationResult(location)
                val latitude = location.lastLocation.latitude
                val longitude = location.lastLocation.longitude
                binding.latitudeTextView.text = latitude.toString()
                binding.longitudeTextView.text = longitude.toString()
            }
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
    }
}