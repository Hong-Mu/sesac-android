package com.hongmu.sesac.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.hongmu.sesac.databinding.ActivityC65Binding

class C65Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC65Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if(it){
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${binding.inputNumber.text.toString()}"))
                startActivity(intent)
            } else {
                Toast.makeText(this, "궈한 거부", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnCall.setOnClickListener {
            val status = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            if(status == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${binding.inputNumber.text.toString()}"))
                startActivity(intent)
            } else {
                permissionLauncher.launch(Manifest.permission.CALL_PHONE)
            }
        }
    }
}