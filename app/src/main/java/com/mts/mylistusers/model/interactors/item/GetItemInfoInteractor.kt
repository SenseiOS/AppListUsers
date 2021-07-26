package com.mts.mylistusers.model.interactors.item

import com.mts.mylistusers.interfaces.Interactor
import com.mts.mylistusers.model.Items
import com.mts.mylistusers.mvi.item.ItemInfoAction
import com.mts.mylistusers.mvi.item.ItemInfoState

class GetItemInfoInteractor: Interactor<ItemInfoState, ItemInfoAction> {
    override suspend fun invoke(state: ItemInfoState, action: ItemInfoAction): ItemInfoAction {
       return if(action is ItemInfoAction.LoadItem){
           try {
               ItemInfoAction.ItemLoaded(Items.getItem(state.itemId))
           }
           catch (e:Exception){
               ItemInfoAction.Error(e)
           }
       } else {
           ItemInfoAction.Error(IllegalArgumentException("Error : $action"))
       }
    }

    override fun canHandle(action: ItemInfoAction): Boolean {
        return action is ItemInfoAction.LoadItem
    }


}
