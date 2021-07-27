package com.mts.mylistusers.mvi.items

import com.mts.mylistusers.interfaces.Reducer

class ItemsReducer: Reducer<ItemsState, ItemsAction> {

    override val initialState = ItemsState(items = listOf(),lastId = 0)

    override fun reduce(state: ItemsState, action: ItemsAction): ItemsState {
        return when(action) {
            ItemsAction.None -> state
            ItemsAction.LoadItems -> state
            is ItemsAction.ItemsLoaded -> state.copy(items=action.items)
            is ItemsAction.SaveLastID -> state.copy(lastId = action.lastId)
            is ItemsAction.Error -> state
        }
    }

}
