package com.hongmu.sesac.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.hongmu.sesac.R

class C72Service : Service() {

    inner class MyBinder: Binder(){
        var player = MediaPlayer()

        fun start(){
            try {
                if(player != null && player.isPlaying){
                    player.stop()
                    player.release()
                }
                player = MediaPlayer.create(applicationContext, R.raw.music)
                player.start()
            } catch (e: Exception){
                e.printStackTrace()
            }
        }

        fun stop(){
            if(player != null && player.isPlaying){
                player.stop()
            }
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return MyBinder()
    }
}