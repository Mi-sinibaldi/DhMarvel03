package com.example.dhmarvel03.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.dhmarvel03.R
import com.example.dhmarvel03.model.ComicsResult
import kotlinx.android.synthetic.main.item_hq_adapter.view.*

class ItemHqAdapter(
    private val listener: ItemListener
) : RecyclerView.Adapter<ItemHqAdapterViewHolder>() {

    interface ItemListener {
        fun onClickedItem(result: ComicsResult)
    }

    private val items = ArrayList<ComicsResult>()

    fun setItems(items: ArrayList<ComicsResult>) {
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

    private lateinit var commicsResult: ComicsResult

    init {
        view.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: ComicsResult) {
        this.commicsResult = item
        var photo = item.thumbnail?.path+"."+item.thumbnail?.extension
        photo = photo.replace("http://","https://")
        view.textViewDescHq.text = "#${item.id}"
        Glide.with(view)
            .load(photo)
            .into(view.imageViewItemHq)
    }

    override fun onClick(v: View?) {
        listener.onClickedItem(commicsResult)
    }
}