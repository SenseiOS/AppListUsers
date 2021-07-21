package com.mts.mylistusers.model


class Item(val id: Int, val name: String, val description: String)
{
    companion object {

        fun createItemsList(): ArrayList<Item> {
            val items = ArrayList<Item>()
            for (i in 0..19) {
                items.add(Item(i, "Name $i","This description users - Name $i"))
            }
            return items
        }

    }

}
