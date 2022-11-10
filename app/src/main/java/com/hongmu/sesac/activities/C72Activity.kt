package com.hongmu.sesac.activities

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.hongmu.sesac.databinding.ActivityC71Binding
import com.hongmu.sesac.services.C72Service

class C72Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC71Binding.inflate(layoutInflater) }
    private lateinit var binder: C72Service.MyBinder

    val connection = object: ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            binder = p1 as C72Service.MyBinder
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.startButton.setOnClickListener {
            binder.start()
            binding.startButton.isEnabled = false
            binding.stopButton.isEnabled = true
        }

        binding.stopButton.setOnClickListener {
            binder.stop()
            binding.startButton.isEnabled = true
            binding.stopButton.isEnabled = false
        }

        bindService(Intent(this, C72Service::class.java), connection, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }
}