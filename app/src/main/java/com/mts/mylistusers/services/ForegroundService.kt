package com.mts.mylistusers.services

import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.mts.mylistusers.R
import com.mts.mylistusers.activities.MainActivity
import com.mts.mylistusers.receivers.MyReceiver

class ForegroundService: Service() {
    private val CHANNEL_ID = "ForegroundService"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {

            val notificationIntent = Intent().also { nIntent ->
                nIntent.action = "com.example.broadcast.MY_NOTIFICATION"
                nIntent.putExtra("lastId", intent.getIntExtra("lastId", 0))
                nIntent.putExtra("lastName", intent.getStringExtra ("lastName"))
                nIntent.putExtra("lastDescription",intent.getStringExtra ("lastDescription"))
                nIntent.`package` = "com.mts.mylistusers"
            }

            val pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, 0)

            val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Kotlin service")
                .setContentText("Open last info user")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .build()

            startForeground(1, notification)
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
