package com.mts.mylistusers.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mts.mylistusers.R
import com.mts.mylistusers.adapter.ItemsAdapter
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.services.ForegroundService

class MainActivity : AppCompatActivity() {

    lateinit var items:ArrayList<Item>
    private lateinit var preferences: SharedPreferences

    private lateinit var lastIdTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lastIdTextView = findViewById<TextView>(R.id.last_id)

        preferences=getSharedPreferences("lastId", Context.MODE_PRIVATE)
        val rvItems = findViewById<View>(R.id.rvItems) as RecyclerView
        items = Item.createItemsList()
        val adapter = ItemsAdapter(items,preferences)
        rvItems.adapter=adapter
        rvItems.layoutManager=LinearLayoutManager(this)

        val startServiceIntent = Intent(baseContext,ForegroundService::class.java)
        ContextCompat.startForegroundService(baseContext,startServiceIntent)

        lastIdTextView.text = getLastId()
    }

    override fun onResume() {
        super.onResume()

        lastIdTextView.text = getLastId()
    }

    //Maybe remove string
    private fun getLastId(): String {
        if(preferences.contains("Saved last id")){
            return preferences.getInt("Saved last id",0).toString()
        }
        else{
            return "0"
        }
    }

    override fun onDestroy() {
        val stopServiceIntent = Intent(baseContext,ForegroundService::class.java)
        baseContext.stopService(stopServiceIntent)
        super.onDestroy()
    }
}
