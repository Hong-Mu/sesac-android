package com.hongmu.sesac.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class C68Receiver : BroadcastReceiver() {

    companion object {
        const val TAG = ".C68Activity"
    }

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "onReceive: 수신완료!")
    }
}