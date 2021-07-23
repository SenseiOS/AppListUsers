package com.mts.mylistusers.presenters

import com.mts.mylistusers.interfaces.AllInfoItemView
import com.mts.mylistusers.model.Items

class AllInfoItemPresenter() {

    private var view: AllInfoItemView? = null

    fun attachView(view: AllInfoItemView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    fun getItem(id:Int) {
        Items.getItem(id)?.let {
            view?.displayInfo(
                it
            )
        }
    }


}
