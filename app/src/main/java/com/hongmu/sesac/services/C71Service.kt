package com.hongmu.sesac.services

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.os.IBinder
import com.hongmu.sesac.R

class C71Service : Service() {

    lateinit var player: MediaPlayer

    var receiver = object: BroadcastReceiver(){
        override fun onReceive(context: Context?, p1: Intent?) {
            val mode = p1?.getStringExtra("MODE")
            if(mode != null){
                if(mode == "start"){
                    try {
                        if(player != null && player.isPlaying){
                            player.stop()
                            player.release()
                        }
                        player = MediaPlayer.create(context, R.raw.music)
                        player.start()
                    } catch (e: Exception){
                        e.printStackTrace()
                    }
                } else if(mode == "stop"){
                    if(player != null && player.isPlaying){
                        player.stop()
                    }
                }
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer()
        registerReceiver(receiver, IntentFilter("PLAY_TO_SERVICE"))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}