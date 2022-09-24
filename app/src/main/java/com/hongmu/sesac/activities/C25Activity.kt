package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.hongmu.sesac.databinding.ActivityC25Binding

class C25Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC25Binding.inflate(layoutInflater) }
    private var pauseTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            binding.chronometer.apply {
                // SystemClock.elapsedRealtime(): 부팅 이후 경과 시간
                base = SystemClock.elapsedRealtime() + pauseTime // 기준 시간 설정
                start()
            }
            binding.btnStart.isEnabled = false
            binding.btnStop.isEnabled = true
            binding.btnReset.isEnabled = true
        }

        binding.btnStop.setOnClickListener {
            binding.chronometer.apply {
                pauseTime = base - SystemClock.elapsedRealtime()
                stop()
            }
            binding.btnStart.isEnabled = true
            binding.btnStop.isEnabled = false
            binding.btnReset.isEnabled = true
        }

        binding.btnReset.setOnClickListener {
            binding.chronometer.apply {
                pauseTime = 0L
                base = SystemClock.elapsedRealtime()
                stop()
            }
            binding.btnStart.isEnabled = true
            binding.btnStop.isEnabled = false
            binding.btnReset.isEnabled = false
        }


    }
}