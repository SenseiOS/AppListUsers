package com.mts.mylistusers.mvi.item

import com.mts.mylistusers.interfaces.Reducer

class ItemInfoReducer(itemId:Int): Reducer<ItemInfoState,ItemInfoAction> {

    override val initialState = ItemInfoState(
        itemId = itemId,
        item = null
    )

    override fun reduce(state: ItemInfoState, action: ItemInfoAction): ItemInfoState {
        return when(action) {
            ItemInfoAction.None -> state
            ItemInfoAction.LoadItem -> state
            is ItemInfoAction.ItemLoaded -> state.copy(
                item = action.item
            )
            is ItemInfoAction.Error -> state
        }
    }


}
