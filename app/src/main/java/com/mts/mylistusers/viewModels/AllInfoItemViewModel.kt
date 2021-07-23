package com.mts.mylistusers.viewModels

import androidx.lifecycle.MutableLiveData
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.model.Items

class AllInfoItemViewModel(
) {

   val item:MutableLiveData<Item> = MutableLiveData()


    fun getItem(id:Int) {
        Items.getItem(id)?.let {
            item?.value = it
        }
    }


}
