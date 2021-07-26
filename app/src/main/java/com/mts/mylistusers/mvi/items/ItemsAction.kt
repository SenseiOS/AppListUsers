package com.mts.mylistusers.mvi.items

import com.mts.mylistusers.model.Item
import java.lang.Exception

sealed class ItemsAction {

    object None: ItemsAction()
    object LoadItems: ItemsAction()
    data class ItemsLoaded(val items: List<Item>): ItemsAction()
    data class Error(val error: Exception): ItemsAction()
}
