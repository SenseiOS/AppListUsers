package com.mts.mylistusers.presenter

import android.content.Intent
import com.mts.mylistusers.interfaces.AllInfoItemView
import com.mts.mylistusers.model.Items

private const val DEFAULT_NUMBER_ID = 0
private const val GET_NAME_ID = "id"

class AllInfoItemPresenter() {

    private var view: AllInfoItemView? = null

    fun attachView(view: AllInfoItemView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    fun getItem(intent: Intent) {
        Items.getItem(intent.getIntExtra(GET_NAME_ID, DEFAULT_NUMBER_ID))?.let {
            view?.displayInfo(
                it
            )
        }
    }


}
