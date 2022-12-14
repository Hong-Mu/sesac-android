package com.hongmu.sesac.activities.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import com.hongmu.sesac.R

class C74Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c74)

        findViewById<Button>(R.id.btnNotice).setOnClickListener {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            val builder: NotificationCompat.Builder
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channelId = "one-channel"
                val channelName = "My One Channel"
                val channel = NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_HIGH
                ).apply {
                    description = "My One Channel Description"
                    setShowBadge(true)
                    val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
                    val audio = AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build()
                    setSound(uri, audio)
                    enableLights(true)
                    lightColor = Color.RED
                    enableVibration(true)
                    vibrationPattern = longArrayOf(100, 200, 100, 200)
                }

                manager.createNotificationChannel(channel)

                builder = NotificationCompat.Builder(this, channelId)
            } else {
                builder = NotificationCompat.Builder(this)
            }

            builder.apply {
                setSmallIcon(android.R.drawable.ic_notification_overlay)
                setWhen(System.currentTimeMillis())
                setContentTitle("Title")
                setContentText("Message")
            }

            val actionIntent = Intent(this, C74SubActivity::class.java)
            val actionPending = PendingIntent.getActivity(this, 20, actionIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(actionPending)

            val actionIntent2 = Intent(this, C74SubActivity::class.java)
            val actionPending2 = PendingIntent.getActivity(this, 20, actionIntent2, PendingIntent.FLAG_UPDATE_CURRENT)

            // ??????
            builder.addAction(
                NotificationCompat.Action.Builder(
                    android.R.drawable.stat_notify_more,
                    "Action",
                    actionPending2
                ).build()
            )

            val bigPicture = BitmapFactory.decodeResource(resources, R.drawable.sunset)
            val style = NotificationCompat.BigPictureStyle()
            style.bigPicture(bigPicture)
            builder.setStyle(style)

            manager.notify(1, builder.build())
        }
    }
}