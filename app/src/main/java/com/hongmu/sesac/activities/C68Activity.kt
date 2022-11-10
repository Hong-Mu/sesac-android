package com.hongmu.sesac.activities

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.databinding.ActivityC68Binding
import com.hongmu.sesac.receivers.C68Receiver

class C68Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC68Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))!!.run {
            var isCharging = "Not Plugged"
            when(getIntExtra(BatteryManager.EXTRA_STATUS, -1)){
                BatteryManager.BATTERY_STATUS_CHARGING -> {
                    // 저속, 고속 충전 상태 확인
                    when(getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)){
                        BatteryManager.BATTERY_PLUGGED_USB -> {
                            isCharging = "USB Plugged"
                        }
                        BatteryManager.BATTERY_PLUGGED_AC -> {
                            isCharging = "AC Plugged"
                        }
                    }
                }
            }

            val level = getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct = level / scale.toFloat() * 100
            binding.textResult.text = "$isCharging, $batteryPct %"
        }

        binding.btnSendBroadCast.setOnClickListener {
            sendBroadcast(Intent(this, C68Receiver::class.java))
        }
    }
}