package com.mts.mylistusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mts.mylistusers.adapter.ItemsAdapter
import com.mts.mylistusers.model.Item

class MainActivity : AppCompatActivity() {

    lateinit var items:ArrayList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvItems = findViewById<View>(R.id.rvItems) as RecyclerView
        items = Item.createItemsList()
        val adapter = ItemsAdapter(items)
        rvItems.adapter=adapter
        rvItems.layoutManager=LinearLayoutManager(this)

    }
}
