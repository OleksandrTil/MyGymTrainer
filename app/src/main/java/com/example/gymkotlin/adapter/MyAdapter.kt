package com.example.gymkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymkotlin.R

class MyAdapter(context: Context?, listMain: ArrayList<Items>, listener: OnItemClick) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private  var inflater = LayoutInflater.from(context)
    private  var listener: OnItemClick = listener
    private var itemList = listMain

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.setData(itemList.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var imViewLogo: ImageView = itemView.findViewById(R.id.imViewLogo)
        private var tvTitle: TextView = itemView.findViewById(R.id.tvTitle)

        fun setData(items: Items) {
            tvTitle.text = items.title
            imViewLogo.setImageResource(items.position)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            listener.onItemClick(view, adapterPosition)
        }
    }

    fun setClickListener(onItemClick: OnItemClick) {
        listener = onItemClick;
    }

    public interface OnItemClick {
        fun onItemClick(view: View, pos: Int)
    }
}