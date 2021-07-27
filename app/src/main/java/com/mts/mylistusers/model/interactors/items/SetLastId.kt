package com.mts.mylistusers.model.interactors.items

import androidx.core.content.edit
import com.mts.mylistusers.interfaces.Interactor
import com.mts.mylistusers.model.Items
import com.mts.mylistusers.model.Preferences
import com.mts.mylistusers.mvi.items.ItemsAction
import com.mts.mylistusers.mvi.items.ItemsState
import java.lang.IllegalArgumentException

private const val NAME_SAVE_PREFERENCE = "Saved last id"

class SetLastId: Interactor<ItemsState, ItemsAction> {
    override suspend fun invoke(state: ItemsState, action: ItemsAction): ItemsAction {

        return if (action is ItemsAction.SaveLastID){
            Preferences.preferences.edit {
                putInt(NAME_SAVE_PREFERENCE, action.lastId).apply()
            }
            ItemsAction.None
        } else {
            ItemsAction.Error(IllegalArgumentException("No element: $action"))
        }
    }

    override fun canHandle(action: ItemsAction): Boolean {
        return action is ItemsAction.SaveLastID
    }
}
