package com.hongmu.sesac.activities.geolocation

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApi
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.hongmu.sesac.R

class C82Activity : AppCompatActivity() {

    private lateinit var providerClient: FusedLocationProviderClient
    private lateinit var textLocation: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c81)

        textLocation = findViewById(R.id.textLocation)

        val apiClient = GoogleApiClient.Builder(this)
            .addApi(LocationServices.API)
            .addConnectionCallbacks(connectionCallback)
            .addOnConnectionFailedListener(connectionFailCallback)
            .build()

        providerClient = LocationServices.getFusedLocationProviderClient(this)

        val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
            if(isGranted){
                apiClient.connect()
            } else {
                Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
            }
        }

        val status = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        if(status == PackageManager.PERMISSION_GRANTED){
            apiClient.connect()
        } else {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
    
    val connectionCallback = object : GoogleApiClient.ConnectionCallbacks {
        @SuppressLint("MissingPermission")
        override fun onConnected(p0: Bundle?) {
            providerClient.lastLocation.addOnCompleteListener {
                if(it.isSuccessful){
                    val latitude = it.result?.latitude
                    val longitude = it.result?.longitude
                    textLocation.text = "$latitude, $longitude"
                }
            }
        }

        override fun onConnectionSuspended(p0: Int) {

        }
    }

    val connectionFailCallback = object: GoogleApiClient.OnConnectionFailedListener {
        override fun onConnectionFailed(p0: ConnectionResult) {
            TODO("Not yet implemented")
        }
    }

}