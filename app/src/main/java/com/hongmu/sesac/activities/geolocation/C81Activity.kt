package com.hongmu.sesac.activities.geolocation;

import android.Manifest
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

import com.hongmu.sesac.R;

class C81Activity : AppCompatActivity(){

    private lateinit var locationManager: LocationManager
    private lateinit var textLocation: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c81)

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        textLocation = findViewById(R.id.textLocation)

        val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
            if(isGranted){
                getLocation()
            } else {
                Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
            }
        }

        val status = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        if(status == PackageManager.PERMISSION_GRANTED){
            getLocation()
        } else {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun getLocation(){
        val location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        location?.let {
            val latitude = it.latitude
            val longitude = it.longitude
            val acc = it.accuracy
            val time = it.time

            textLocation.text = "$latitude, $longitude, $acc, $time"
        }
    }

}