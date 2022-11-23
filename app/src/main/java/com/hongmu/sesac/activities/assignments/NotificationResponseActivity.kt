package com.hongmu.sesac.activities.assignments

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.hongmu.sesac.R
import com.hongmu.sesac.receivers.NotificationReceiver
import com.hongmu.sesac.utils.Keys

class NotificationResponseActivity : AppCompatActivity() {

    private val notificationManager by lazy { getSystemService(NOTIFICATION_SERVICE) as NotificationManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_response)

        createChannel()

        findViewById<Button>(R.id.btnNotify).setOnClickListener {

            val notification = createNotification()
            notificationManager.notify(1, notification)
        }
    }

    private fun createChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "MY_CHANNEL",
                "알림 채널",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createNotification(): Notification{

        val remoteInput = RemoteInput.Builder(Keys.KEY_TEXT_REPLY)
            .setLabel("입력")
            .build()

        val replyIntent = Intent(this, NotificationReceiver::class.java)

        val replyPendingIntent = PendingIntent.getBroadcast(this, 0, replyIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val action = NotificationCompat.Action.Builder(android.R.drawable.stat_notify_chat, "답장", replyPendingIntent)
            .addRemoteInput(remoteInput)
            .build()

        val builder = NotificationCompat.Builder(this, "MY_CHANNEL")
            .setSmallIcon(android.R.drawable.ic_notification_overlay)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.sunset))
            .setContentTitle("채홍무")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentText("안녕하세요!")
            .addAction(action)

        return builder.build()
    }

}