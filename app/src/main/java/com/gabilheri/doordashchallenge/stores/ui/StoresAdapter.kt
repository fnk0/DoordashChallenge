package com.gabilheri.doordashchallenge.stores.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gabilheri.doordashchallenge.R
import com.gabilheri.doordashchallenge.stores.data.StoreItem

class StoresAdapter : ListAdapter<StoreItem, StoreViewHolder>(GifDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_store, parent, false)
        return StoreViewHolder(itemView = view)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private object GifDiff : DiffUtil.ItemCallback<StoreItem>() {
    override fun areItemsTheSame(oldItem: StoreItem, newItem: StoreItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: StoreItem, newItem: StoreItem): Boolean {
        return oldItem == newItem
    }
}