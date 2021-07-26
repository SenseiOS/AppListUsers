package com.mts.mylistusers.model.interactors.items

import com.mts.mylistusers.interfaces.Interactor
import com.mts.mylistusers.model.Items
import com.mts.mylistusers.mvi.items.ItemsAction
import com.mts.mylistusers.mvi.items.ItemsState
import java.lang.IllegalArgumentException

class GetItemsInteractor: Interactor<ItemsState, ItemsAction> {
    override suspend fun invoke(state: ItemsState, action: ItemsAction): ItemsAction {
        return if (action is ItemsAction.LoadItems){
            ItemsAction.ItemsLoaded(Items.items)
        } else {
            ItemsAction.Error(IllegalArgumentException("No element: $action"))
        }
    }

    override fun canHandle(action: ItemsAction): Boolean {
       return action is ItemsAction.LoadItems
    }
}
