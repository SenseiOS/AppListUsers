package com.mts.mylistusers.services

import android.app.*
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.mts.mylistusers.R

private const val CHANNEL_ID = "ForegroundService"
private const val NAME_CTION = "com.example.broadcast.MY_NOTIFICATION"
private const val NAME_PACKAGE = "com.mts.mylistusers"
private const val NOTIFICATION_TITLE = "Kotlin service"
private const val NOTIFICATION_TEXT = "Open last info user"
private const val NOTIFICATION_ID = 1

class ForegroundService: Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {

            val notificationIntent = Intent().also { nIntent ->
                nIntent.action = NAME_CTION
                nIntent.`package` = NAME_PACKAGE
            }

            val pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, 0)

            val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(NOTIFICATION_TITLE)
                .setContentText(NOTIFICATION_TEXT)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .build()

            startForeground(NOTIFICATION_ID, notification)
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
