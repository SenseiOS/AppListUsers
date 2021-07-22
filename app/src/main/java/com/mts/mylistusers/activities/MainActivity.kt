package com.mts.mylistusers.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mts.mylistusers.MainPresenter
import com.mts.mylistusers.R
import com.mts.mylistusers.adapter.ItemsAdapter
import com.mts.mylistusers.interfaces.MainView
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.model.Preferences
import com.mts.mylistusers.services.ForegroundService
import com.mts.mylistusers.viewModel.MainViewModel
import com.mts.mylistusers.viewModel.MainViewModelFactory
import java.util.Observer

private const val PUT_ID_NAME = "id"

class MainActivity : AppCompatActivity() {

    lateinit var adapter:ItemsAdapter

    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startApplication()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun startApplication() {


        val rvItems = findViewById<View>(R.id.rvItems) as RecyclerView


        adapter = ItemsAdapter {
            val infoIntent = Intent(this, AllInfoItemActivity::class.java)

            infoIntent.putExtra(PUT_ID_NAME, it.id)

           viewModel.saveItemId(it.id)

            this.startActivity(infoIntent)
        }

        rvItems.layoutManager=LinearLayoutManager(this)
        rvItems.adapter=adapter

        viewModel.items. observe()
        adapter.submitList()

        val startServiceIntent = Intent(baseContext, ForegroundService::class.java)
        ContextCompat.startForegroundService(baseContext, startServiceIntent)

    }
    
    private fun getViewModel() = ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)

}
