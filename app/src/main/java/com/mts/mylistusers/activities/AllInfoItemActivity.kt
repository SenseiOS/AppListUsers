package com.mts.mylistusers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mts.mylistusers.*
import com.mts.mylistusers.interfaces.AllInfoItemView
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.presenter.AllInfoItemPresenter


class AllInfoItemActivity : AppCompatActivity(), AllInfoItemView {

    private lateinit var idTextView:TextView
    private lateinit var nameTextView:TextView
    private lateinit var descriptionTextView:TextView

    private val presenter by lazy {
        AllInfoItemPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_info_item)

        idTextView = findViewById(R.id.info_id)
        nameTextView = findViewById(R.id.info_name)
        descriptionTextView = findViewById(R.id.info_description)

        presenter.attachView(this)

        presenter.getItem(intent)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun displayInfo(item: Item) {
        idTextView.text = item.id.toString()
        nameTextView.text = item.name
        descriptionTextView.text = item.description
    }

}
