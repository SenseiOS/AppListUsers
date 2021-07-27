package com.mts.mylistusers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mts.mylistusers.*
import com.mts.mylistusers.model.interactors.item.GetItemInfoInteractor
import com.mts.mylistusers.mvi.item.ItemInfoState
import com.mts.mylistusers.mvi.item.ItemInfoViewModel


private const val DEFAULT_NUMBER_ID = 0
private const val GET_NAME_ID = "id"

class AllInfoItemActivity : AppCompatActivity() {

    private lateinit var idTextView:TextView
    private lateinit var nameTextView:TextView
    private lateinit var descriptionTextView:TextView

    private val viewModel:ItemInfoViewModel by lazy {
        ItemInfoViewModel(
            interactors = setOf(
                GetItemInfoInteractor()
            ),
            itemId = itemId
        )
    }
    private val itemId by lazy {
        intent.getIntExtra(GET_NAME_ID, DEFAULT_NUMBER_ID)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_info_item)

        idTextView = findViewById(R.id.info_id)
        nameTextView = findViewById(R.id.info_name)
        descriptionTextView = findViewById(R.id.info_description)


        viewModel.state.observe(this, ::displayInfo)
        viewModel.loadItem()

    }

    private fun displayInfo(newState:ItemInfoState) {
        newState.item?.also { item ->
        idTextView.text = item.id.toString()
        nameTextView.text = item.name
        descriptionTextView.text = item.description
        }
    }

}
