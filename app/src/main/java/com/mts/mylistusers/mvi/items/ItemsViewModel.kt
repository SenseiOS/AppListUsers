package com.mts.mylistusers.mvi.items

import com.mts.mylistusers.interfaces.Interactor
import com.mts.mylistusers.viewModels.BaseViewModel

class ItemsViewModel(
    interactors: Set<Interactor<ItemsState, ItemsAction>>
): BaseViewModel<ItemsState, ItemsAction>(
    interactors = interactors,
    reducer = ItemsReducer()
) {

    fun loadItems() {
        action(ItemsAction.LoadItems)
    }
}
