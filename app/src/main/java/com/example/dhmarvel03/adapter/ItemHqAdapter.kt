package com.example.dhmarvel03.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dhmarvel03.R
import com.example.dhmarvel03.model.CommicsResult

class ItemHqAdapter(
    private val listener: ItemListener
) : RecyclerView.Adapter<ItemHqAdapterViewHolder>() {

    interface ItemListener {
        fun onClickedItem(result: CommicsResult)
    }

    private val items = ArrayList<CommicsResult>()

    fun setItems(items: ArrayList<CommicsResult>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHqAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hq_adapter, parent, false)
        return ItemHqAdapterViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemHqAdapterViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class ItemHqAdapterViewHolder(
    private val view: View,
    private val listener: ItemHqAdapter.ItemListener
) : RecyclerView.ViewHolder(view),
    View.OnClickListener {

    private lateinit var commicsResult: CommicsResult

    init {
        view.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: CommicsResult) {
        this.commicsResult = item
        //view.textViewTitleRepository.text = item.name
    }

    override fun onClick(v: View?) {
        //listener.onClickedItem(items)
    }
}