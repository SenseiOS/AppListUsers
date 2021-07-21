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

    private val SAVED_NAME_ID = "Saved last id"
    private val PUT_ID_NAME = "id"
    private val DEFAULT_NUNMBER_ID = 0

    override fun onReceive(context: Context, intent: Intent) {

        val lastId:Int= if(Preferences.preferences.contains(SAVED_NAME_ID)){
             Preferences.preferences.getInt(SAVED_NAME_ID,DEFAULT_NUNMBER_ID)
        }
        else{
            DEFAULT_NUNMBER_ID
        }

        val resultIntent = Intent(context, AllInfoItemActivity::class.java)
        resultIntent.putExtra(PUT_ID_NAME, lastId)

        val stackBuilder: TaskStackBuilder = TaskStackBuilder.create(context)
        stackBuilder.addParentStack(AllInfoItemActivity::class.java)
        stackBuilder.addNextIntent(resultIntent)

        stackBuilder.startActivities()
    }
}
