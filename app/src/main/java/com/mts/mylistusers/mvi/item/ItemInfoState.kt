package com.mts.mylistusers.mvi.item

import com.mts.mylistusers.model.Item

data class ItemInfoState(
    val itemId: Int,
    val item:Item?
)
