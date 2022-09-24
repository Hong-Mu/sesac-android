package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import com.hongmu.sesac.databinding.ActivityC25Binding

class C25Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC25Binding.inflate(layoutInflater) }
    private var initTime = 0L
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

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis() - initTime > 3000){
                Toast.makeText(this, "종료하려면 한 번 더 누르세요!", Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}