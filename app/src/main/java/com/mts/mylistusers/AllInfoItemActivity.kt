package com.mts.mylistusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class AllInfoItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_info_item)

        val idTextView = findViewById<TextView>(R.id.info_id)
        val nameTextView = findViewById<TextView>(R.id.info_name)
        val descriptionTextView = findViewById<TextView>(R.id.info_description)

        idTextView.text = intent.getIntExtra("id",0).toString()
        nameTextView.text = intent.getStringExtra("name")
        descriptionTextView.text = intent.getStringExtra ("description")
    }

    fun closeActivity(view: View) {
        finish()
    }
}
