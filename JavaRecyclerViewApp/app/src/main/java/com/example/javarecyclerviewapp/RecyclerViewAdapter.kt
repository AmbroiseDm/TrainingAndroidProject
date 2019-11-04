package com.example.javarecyclerviewapp

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso

import java.util.ArrayList

class RecyclerViewAdapter(private val context: Context, listItms: ArrayList<ListItems>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var listItems = ArrayList<ListItems>()
    private val fullList: ArrayList<ListItems>
    private var filtered = false

    init {
        this.listItems = listItms
        this.fullList = listItms
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = listItems[position].text
        Picasso.get().load(listItems[position].image).into(holder.image)
        holder.layout.setBackgroundColor(listItems[position].color)
    }


    override fun getItemCount(): Int {
        return listItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var image: ImageView = itemView.findViewById(R.id.imageView)
        internal var text: TextView = itemView.findViewById(R.id.textView)
        internal var layout: RelativeLayout = itemView.findViewById(R.id.relativeLayout)

        init {
            itemView.setOnClickListener {
                if (!filtered) {
                    filter(listItems[adapterPosition].color)
                } else {
                    listItems = fullList
                    filtered = false
                    notifyDataSetChanged()
                }
            }
        }

    }

    private fun filter(color: Int) {
        val filteredList = ArrayList<ListItems>()

        for (item in listItems) {
            if (item.color == color) {
                filteredList.add(item)
            }
        }
        listItems = filteredList
        filtered = true
        notifyDataSetChanged()
    }
}
