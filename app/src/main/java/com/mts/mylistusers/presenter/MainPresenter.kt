package com.mts.mylistusers

import android.content.SharedPreferences
import androidx.core.content.edit
import com.mts.mylistusers.interfaces.MainView
import com.mts.mylistusers.model.Items

private const val NAME_SAVE_PREFERENCE = "Saved last id"

class MainPresenter(
    private val preferences: SharedPreferences
) {


    private var view: MainView? = null


    fun attachView(view: MainView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    fun getItems() {
        val items = Items.items
        view?.displayItems(items)
    }

    fun saveItemId(id: Int) {
        preferences.edit {
            putInt(NAME_SAVE_PREFERENCE, id).apply()
        }
    }


}


