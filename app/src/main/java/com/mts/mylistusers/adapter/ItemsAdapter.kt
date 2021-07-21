package com.mts.mylistusers.adapter

import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mts.mylistusers.activities.AllInfoItemActivity
import com.mts.mylistusers.activities.MainActivity
import com.mts.mylistusers.R
import com.mts.mylistusers.model.Item
import com.mts.mylistusers.model.Items

class ItemsAdapter(val clickListener: (Item)-> Unit):ListAdapter<Item,ItemsAdapter.MyViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: Item = currentList[position]
        val textView = holder.nameTextView
        textView.text = item.name

        holder.itemView.setOnClickListener {v ->
            clickListener(item)
        }
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val nameTextView=itemView.findViewById<TextView>(R.id.txt_name)
    }

    class DiffCallback: DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

}
