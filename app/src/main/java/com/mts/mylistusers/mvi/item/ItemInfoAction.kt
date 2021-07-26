package com.mts.mylistusers.mvi.item

import com.mts.mylistusers.model.Item

sealed class ItemInfoAction {

    object None: ItemInfoAction()
    object LoadItem: ItemInfoAction()
    data class ItemLoaded(val item: Item): ItemInfoAction()
    data class Error(val error: Exception): ItemInfoAction()
}
