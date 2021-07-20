package com.mts.mylistusers.receivers

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mts.mylistusers.activities.AllInfoItemActivity


class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        /*val infoIntent = Intent(context, AllInfoItemActivity::class.java)

        infoIntent.putExtra("id", intent.getIntExtra("id",0))
        infoIntent.putExtra("name", intent.getStringExtra("name"))
        infoIntent.putExtra("description", intent.getStringExtra ("description"))

        context.startActivity(infoIntent)*/

        // Create PendingIntent
        val resultIntent = Intent(context, AllInfoItemActivity::class.java)
        resultIntent.putExtra("lastId", intent.getIntExtra("id",0))
        resultIntent.putExtra("lastName", intent.getStringExtra("name"))
        resultIntent.putExtra("lastDescription", intent.getStringExtra ("description"))

        val stackBuilder: TaskStackBuilder = TaskStackBuilder.create(context)
        stackBuilder.addParentStack(AllInfoItemActivity::class.java)
        stackBuilder.addNextIntent(resultIntent)

        stackBuilder.startActivities()
    }
}
