package com.mts.mylistusers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import com.mts.mylistusers.*
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.viewModels.AllInfoItemViewModel


private const val DEFAULT_NUMBER_ID = 0
private const val GET_NAME_ID = "id"

class AllInfoItemActivity : AppCompatActivity() {

    private lateinit var idTextView:TextView
    private lateinit var nameTextView:TextView
    private lateinit var descriptionTextView:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_info_item)

        idTextView = findViewById(R.id.info_id)
        nameTextView = findViewById(R.id.info_name)
        descriptionTextView = findViewById(R.id.info_description)

        val viewModel = AllInfoItemViewModel()

        viewModel.item.observe(this, Observer { displayInfo(it) })
        viewModel.getItem(intent.getIntExtra(GET_NAME_ID, DEFAULT_NUMBER_ID))

    }

    private fun displayInfo(item: Item) {
        idTextView.text = item.id.toString()
        nameTextView.text = item.name
        descriptionTextView.text = item.description
    }

}
