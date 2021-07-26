package com.mts.mylistusers.viewModels

import android.app.Application
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.model.Items
import com.mts.mylistusers.model.Preferences


private const val NAME_SAVE_PREFERENCE = "Saved last id"

class MainViewModel() {

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
