package com.mts.mylistusers.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.model.Items

class AllInfoItemViewModel : ViewModel() {

    val item: MutableLiveData<Item> = MutableLiveData()


    fun getItem(id: Int) {
        Items.getItem(id)?.let {
            item?.value = it
        }
    }


}
