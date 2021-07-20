package com.mts.mylistusers.adapter

import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mts.mylistusers.activities.AllInfoItemActivity
import com.mts.mylistusers.R
import com.mts.mylistusers.model.Item

class ItemsAdapter(private val items:List<Item>, private val preference:SharedPreferences):RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Item = items[position]
        val textView = holder.nameTextView
        textView.text = item.name

        holder.itemView.setOnClickListener(object:View.OnClickListener{

            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val infoIntent = Intent(activity, AllInfoItemActivity::class.java)

                infoIntent.putExtra("id", item.id)
                infoIntent.putExtra("name", item.name)
                infoIntent.putExtra("description", item.description)

                val editor = preference.edit()
                editor.putInt("Saved last id",item.id).apply()

                activity.startActivity(infoIntent)
            }
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView =itemView.findViewById<TextView>(R.id.txt_name)
    }
}
