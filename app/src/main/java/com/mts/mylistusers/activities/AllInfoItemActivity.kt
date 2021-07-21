package com.mts.mylistusers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.mts.mylistusers.R
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.model.Items

class AllInfoItemActivity : AppCompatActivity() {


    private val DEFAULT_NUNMBER_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_info_item)

        val idTextView = findViewById<TextView>(R.id.info_id)
        val nameTextView = findViewById<TextView>(R.id.info_name)
        val descriptionTextView = findViewById<TextView>(R.id.info_description)

        val resItem: Item? = Items.getItem(intent.getIntExtra("id",DEFAULT_NUNMBER_ID))
        resItem?.let {
            idTextView.text = resItem.id.toString()
            nameTextView.text = resItem.name
            descriptionTextView.text = resItem.description
        }
    }

}
