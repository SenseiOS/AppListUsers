package com.mts.mylistusers.activities

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mts.mylistusers.R
import com.mts.mylistusers.adapter.ItemsAdapter
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.model.Items
import com.mts.mylistusers.model.Preferences
import com.mts.mylistusers.receivers.MyReceiver
import com.mts.mylistusers.services.ForegroundService

private const val NAME_SAVE_PREFERENCE = "Saved last id"
private const val PUT_ID_NAME = "id"
private const val NAME_PREFERENCES = "lastId"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Preferences.preferences=getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE)

        val rvItems = findViewById<View>(R.id.rvItems) as RecyclerView

        val adapter = ItemsAdapter {
            val infoIntent = Intent(this, AllInfoItemActivity::class.java)

            infoIntent.putExtra(PUT_ID_NAME, it.id)

            val editor = Preferences.preferences.edit()
            editor.putInt(NAME_SAVE_PREFERENCE, it.id).apply()

            this.startActivity(infoIntent)
        }

        rvItems.layoutManager=LinearLayoutManager(this)
        rvItems.adapter=adapter
        adapter.submitList(Items.items)

        val startServiceIntent = Intent(baseContext,ForegroundService::class.java)
        ContextCompat.startForegroundService(baseContext, startServiceIntent)
    }


}
