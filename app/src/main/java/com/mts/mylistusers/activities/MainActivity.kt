package com.mts.mylistusers.activities

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
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


class MainActivity : AppCompatActivity() {

    private lateinit var lastIdTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Preferences.preferences=getSharedPreferences("lastId", Context.MODE_PRIVATE)
        val rvItems = findViewById<View>(R.id.rvItems) as RecyclerView

        Items.items = Item.createItemsList()

        val adapter = ItemsAdapter(Items.items,Preferences.preferences)
        rvItems.adapter=adapter
        rvItems.layoutManager=LinearLayoutManager(this)

        val startServiceIntent = Intent(baseContext,ForegroundService::class.java)
        ContextCompat.startForegroundService(baseContext, startServiceIntent!!)
    }


}
