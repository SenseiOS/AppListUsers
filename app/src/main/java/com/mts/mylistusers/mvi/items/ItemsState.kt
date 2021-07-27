package com.mts.mylistusers.mvi.items

import android.content.SharedPreferences
import com.mts.mylistusers.model.Item

data class ItemsState(
    val items: List<Item>,
    val lastId: Int
)
