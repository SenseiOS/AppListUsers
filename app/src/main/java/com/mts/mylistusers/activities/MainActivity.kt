package com.mts.mylistusers.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mts.mylistusers.MainPresenter
import com.mts.mylistusers.R
import com.mts.mylistusers.adapter.ItemsAdapter
import com.mts.mylistusers.interfaces.MainView
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.model.Preferences
import com.mts.mylistusers.services.ForegroundService

private const val PUT_ID_NAME = "id"

class MainActivity : AppCompatActivity(), MainView {

    lateinit var adapter:ItemsAdapter

   private val presenter by lazy {
       MainPresenter(Preferences.preferences)
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        startApplication()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    private fun startApplication() {


        val rvItems = findViewById<View>(R.id.rvItems) as RecyclerView


        adapter = ItemsAdapter {
            val infoIntent = Intent(this, AllInfoItemActivity::class.java)

            infoIntent.putExtra(PUT_ID_NAME, it.id)

            presenter.saveItemId(it.id)

            this.startActivity(infoIntent)
        }

        rvItems.layoutManager=LinearLayoutManager(this)
        rvItems.adapter=adapter

        presenter.getItems()

        val startServiceIntent = Intent(baseContext, ForegroundService::class.java)
        ContextCompat.startForegroundService(baseContext, startServiceIntent)

    }

    override fun displayItems(items: List<Item>) {
        adapter.submitList(items)
    }


}
