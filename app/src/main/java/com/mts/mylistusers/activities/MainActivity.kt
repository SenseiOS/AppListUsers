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
import com.mts.mylistusers.receivers.MyReceiver
import com.mts.mylistusers.services.ForegroundService


class MainActivity : AppCompatActivity() {

    lateinit var items:ArrayList<Item>
    private lateinit var preferences: SharedPreferences

    private lateinit var lastIdTextView:TextView

    //var startServiceIntent:Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lastIdTextView = findViewById<TextView>(R.id.last_id)

        preferences=getSharedPreferences("lastId", Context.MODE_PRIVATE)
        val rvItems = findViewById<View>(R.id.rvItems) as RecyclerView

        items = Item.createItemsList()

        val adapter = ItemsAdapter(items,preferences)
        rvItems.adapter=adapter
        rvItems.layoutManager=LinearLayoutManager(this)

        val startServiceIntent = Intent(baseContext,ForegroundService::class.java)
        //sendInfoService(startServiceIntent!!)


        startServiceIntent.putExtra("lastId", items[getLastId()].id)
        startServiceIntent.putExtra("lastName", items[getLastId()].name)
        startServiceIntent.putExtra("lastDescription", items[getLastId()].description)

        ContextCompat.startForegroundService(baseContext, startServiceIntent!!)

        //lastIdTextView.text = getLastId()
    }

    override fun onResume() {
        super.onResume()

        //sendInfoService(startServiceIntent!!)
        //ContextCompat.startForegroundService(baseContext, startServiceIntent!!)

        //lastIdTextView.text = getLastId()
    }

    private fun getLastId(): Int {
        if(preferences.contains("Saved last id")){
            return preferences.getInt("Saved last id",0)
        }
        else{
            return 0
        }
    }

    private fun sendInfoService(intent:Intent) {
        intent.putExtra("lastId", items[getLastId()].id)
        intent.putExtra("lastName", items[getLastId()].name)
        intent.putExtra("lastDescription", items[getLastId()].description)
    }

    override fun onDestroy() {
        super.onDestroy()

        /*val stopServiceIntent = Intent(baseContext,ForegroundService::class.java)
        baseContext.stopService(stopServiceIntent)*/
    }
}
