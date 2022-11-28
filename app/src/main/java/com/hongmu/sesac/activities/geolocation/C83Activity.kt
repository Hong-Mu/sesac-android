package com.hongmu.sesac.activities.geolocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.hongmu.sesac.R

class C83Activity : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c83)

        (supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment).getMapAsync(this)

    }

    override fun onMapReady(p0: GoogleMap) {
        googleMap = p0
        val latLng = LatLng(37.631644, 127.080214)
        val position = CameraPosition.Builder()
            .target(latLng)
            .zoom(16f)
            .build()

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(position))
    }
}