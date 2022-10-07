package com.hongmu.sesac.activities

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.hongmu.sesac.R

class C51Activity : AppCompatActivity() {

    private val launcher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
        if(it){
            Toast.makeText(this, "허용됨", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "거부하지 마요", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c51)

        val status = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        if(status == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "허용", Toast.LENGTH_SHORT).show()
        } else {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
//                100
//            )
            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "허용", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "왜 거부하셨나요?", Toast.LENGTH_SHORT).show()
        }
    }
}