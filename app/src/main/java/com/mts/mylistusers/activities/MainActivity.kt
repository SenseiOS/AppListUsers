package com.mts.mylistusers.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mts.mylistusers.R
import com.mts.mylistusers.adapter.ItemsAdapter
import com.mts.mylistusers.model.interactors.items.GetItemsInteractor
import com.mts.mylistusers.model.interactors.items.SetLastId
import com.mts.mylistusers.mvi.items.ItemsState
import com.mts.mylistusers.mvi.items.ItemsViewModel
import com.mts.mylistusers.services.ForegroundService
import com.mts.mylistusers.utils.createViewModel

private const val PUT_ID_NAME = "id"

class MainActivity : AppCompatActivity() {

    lateinit var adapter:ItemsAdapter

    private val viewModel:ItemsViewModel by lazy {
        createViewModel {
            ItemsViewModel(
                interactors = setOf(
                    GetItemsInteractor(),
                    SetLastId()
           )
       )}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.state.observe(this, ::displayInfo)
        viewModel.loadItems()
        startApplication()
    }

    private fun startApplication() {


        val rvItems = findViewById<View>(R.id.rvItems) as RecyclerView


        adapter = ItemsAdapter {
            val infoIntent = Intent(this, AllInfoItemActivity::class.java)

            infoIntent.putExtra(PUT_ID_NAME, it.id)

            viewModel.saveLastId(it.id)

            this.startActivity(infoIntent)
        }

        rvItems.layoutManager=LinearLayoutManager(this)
        rvItems.adapter=adapter


        val startServiceIntent = Intent(baseContext, ForegroundService::class.java)
        ContextCompat.startForegroundService(baseContext, startServiceIntent)

    }

    private fun displayInfo(newState: ItemsState) {
        adapter.submitList(newState.items)
    }

}
