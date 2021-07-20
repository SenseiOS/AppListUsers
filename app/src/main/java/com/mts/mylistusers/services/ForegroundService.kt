package com.mts.mylistusers.services

import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.mts.mylistusers.R
import com.mts.mylistusers.activities.MainActivity

class ForegroundService: Service() {
    private val CHANNEL_ID = "ForegroundService"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0)

        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Kotlin service")
            .setContentText("Open last info user")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1,notification)

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
