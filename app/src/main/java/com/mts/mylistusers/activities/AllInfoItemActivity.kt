package com.mts.mylistusers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mts.mylistusers.R
import com.mts.mylistusers.model.Items

private const val DEFAULT_NUMBER_ID = 0
private const val GET_NAME_ID = "id"

class AllInfoItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_info_item)

        val idTextView = findViewById<TextView>(R.id.info_id)
        val nameTextView = findViewById<TextView>(R.id.info_name)
        val descriptionTextView = findViewById<TextView>(R.id.info_description)

        Items.getItem(intent.getIntExtra(GET_NAME_ID,DEFAULT_NUMBER_ID))?.also { resItem->
            idTextView.text = resItem.id.toString()
            nameTextView.text = resItem.name
            descriptionTextView.text = resItem.description
        }
    }

}
