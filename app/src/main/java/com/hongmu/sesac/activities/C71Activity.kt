package com.hongmu.sesac.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.databinding.ActivityC71Binding
import com.hongmu.sesac.services.C71Service

class C71Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC71Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            sendBroadcast(Intent("PLAY_TO_SERVICE").apply {
                putExtra("MODE", "start")
            })

            binding.startButton.isEnabled = false
            binding.stopButton.isEnabled = true
        }

        binding.stopButton.setOnClickListener {
            sendBroadcast(Intent("PLAY_TO_SERVICE").apply {
                putExtra("MODE", "stop")
            })

            binding.startButton.isEnabled = true
            binding.stopButton.isEnabled = false
        }

        startService(Intent(this, C71Service::class.java))

    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this, C71Service::class.java))
    }
}