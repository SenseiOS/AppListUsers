package com.mts.mylistusers.viewModels

import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.model.Items
import com.mts.mylistusers.model.Preferences


private const val NAME_SAVE_PREFERENCE = "Saved last id"

class MainViewModel:ViewModel() {

    val liveItems = MutableLiveData<ArrayList<Item>>()

    init {
        getItems()
    }

    private fun getItems(){
        liveItems.value = Items.items
    }

    fun saveItemId(id: Int) {
        Preferences.preferences.edit {
            putInt(NAME_SAVE_PREFERENCE, id).apply()
        }
    }
}
