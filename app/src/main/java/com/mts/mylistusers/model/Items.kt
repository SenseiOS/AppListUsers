package com.mts.mylistusers.model

object Items {
    val items by lazy {
        createItemsList()
    }

    private fun createItemsList(): ArrayList<Item> {
        val items = ArrayList<Item>()
        for (i in 0..19) {
            items.add(Item(i, "Name $i","This description users - Name $i"))
        }
        return items
    }
    fun getItem(lastId:Int): Item {
       return items.find { it.id == lastId}!!
    }

}
