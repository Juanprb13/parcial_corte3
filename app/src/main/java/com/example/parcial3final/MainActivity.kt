package com.example.parcial3final

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.parcial3final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val requestLocationPermission = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.startButton.setOnClickListener{
            validatePermission()
        }
    }
    private fun validatePermission (){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            nextStep()
        }else{
            requestPermission()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode === requestLocationPermission){
            if (grantResults[0] === PackageManager.PERMISSION_GRANTED){
                nextStep()
            } else {
                Toast.makeText(this,"El permiso es necesario", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun requestPermission (){
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),requestLocationPermission);

    }

    private fun nextStep (){
        val intent = Intent(this, TabsActivity::class.java)
        startActivity(intent)
    }
}