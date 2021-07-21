package com.mts.mylistusers.receivers

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mts.mylistusers.activities.AllInfoItemActivity
import com.mts.mylistusers.model.Items
import com.mts.mylistusers.model.Preferences


class MyReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {

        var lastId:Int

        if(Preferences.preferences.contains("Saved last id")){
             lastId = Preferences.preferences.getInt("Saved last id",0)
        }
        else{
            lastId = 0
        }

        val resultIntent = Intent(context, AllInfoItemActivity::class.java)
        resultIntent.putExtra("id", lastId)
        resultIntent.putExtra("name", Items.items[lastId].name )
        resultIntent.putExtra("description", Items.items[lastId].description)

        val stackBuilder: TaskStackBuilder = TaskStackBuilder.create(context)
        stackBuilder.addParentStack(AllInfoItemActivity::class.java)
        stackBuilder.addNextIntent(resultIntent)

        stackBuilder.startActivities()
    }
}
