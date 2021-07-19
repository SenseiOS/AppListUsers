package com.mts.mylistusers

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mts.mylistusers.adapter.ItemsAdapter
import com.mts.mylistusers.model.Item

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

        lastIdTextView.text = getLastId()
    }

    override fun onResume() {
        super.onResume()

        lastIdTextView.text = getLastId()
    }

    private fun getLastId(): String {
        if(preferences.contains("Saved last id")){
            return preferences.getInt("Saved last id",0).toString()
        }
        else{
            return "0"
        }
    }
}
