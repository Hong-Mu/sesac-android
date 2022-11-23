package com.hongmu.sesac.receivers

import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.hongmu.sesac.R
import com.hongmu.sesac.utils.Keys

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val replyBundle = RemoteInput.getResultsFromIntent(intent)
        val reply = replyBundle.getCharSequence(Keys.KEY_TEXT_REPLY)
        if(reply != null){
            Toast.makeText(context, reply, Toast.LENGTH_SHORT).show()
            createNotification(context)
        } else {
            Toast.makeText(context, "전송 실패", Toast.LENGTH_SHORT).show()       
        }
    }

    private fun createNotification(context: Context){
        val builder = NotificationCompat.Builder(context, "MY_CHANNEL")
            .setSmallIcon(android.R.drawable.ic_notification_overlay)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.sunset))
            .setContentTitle("채홍무")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentText("안녕하세요!")

        NotificationManagerCompat.from(context).notify(1, builder.build())
    }
}