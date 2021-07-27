package com.mts.mylistusers.mvi.item

import com.mts.mylistusers.interfaces.Interactor
import com.mts.mylistusers.viewModels.BaseViewModel

class ItemInfoViewModel(
    interactors: Set<Interactor<ItemInfoState, ItemInfoAction>>,
    itemId: Int
) : BaseViewModel<ItemInfoState, ItemInfoAction>(
    interactors = interactors,
    reducer = ItemInfoReducer(itemId)
) {

    fun loadItem() {
        action(ItemInfoAction.LoadItem)
    }
}
