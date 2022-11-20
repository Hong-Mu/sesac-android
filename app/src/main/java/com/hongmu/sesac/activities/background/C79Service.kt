package com.hongmu.sesac.activities.background

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.IBinder
import android.util.Log

class C79Service : JobService() {

    override fun onCreate() {
        super.onCreate()
        Log.d(".C79Service", "onCreate: C79")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(".C79Service", "onDestroy: C79")
    }

    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.d(".C79Service", "onStartJob: C79")
        return false
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d(".C79Service", "onStopJob: C79")
        return false
    }
}