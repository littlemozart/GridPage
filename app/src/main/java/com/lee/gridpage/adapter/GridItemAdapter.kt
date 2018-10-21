package com.lee.gridpage.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.lee.gridpage.R
import com.lee.gridpage.model.Data

class GridItemAdapter(private val context: Context) : RecyclerView.Adapter<GridItemAdapter.ItemViewHolder>() {
    var mList: List<Data>? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_grid, p0, false))
    }

    override fun getItemCount(): Int = mList?.size ?: 0

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {
        p0.text?.text = mList!![p1].text
        p0.icon?.setImageResource(mList!![p1].icon)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text: TextView? = null
        var icon: ImageView? = null

        init {
            text = itemView.findViewById(R.id.text)
            icon = itemView.findViewById(R.id.icon)
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, text?.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}