package com.hongmu.sesac.activities.background

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.hongmu.sesac.R

class C79Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c79)


        findViewById<Button>(R.id.btnStart).setOnClickListener {
            Log.d(".C79Activity", "onCreate: Button")
            val scheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler

            JobInfo.Builder(1, ComponentName(this, C79Service::class.java)).run {
                setRequiresCharging(false)
                scheduler.schedule(build())
            }
        }
    }
}