package com.gabilheri.doordashchallenge.stores.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.gabilheri.doordashchallenge.R
import com.gabilheri.doordashchallenge.stores.data.StoreItem

class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val headerImage by lazy<ImageView> { itemView.findViewById(R.id.store_item_header_image) }
    private val name by lazy<TextView> { itemView.findViewById(R.id.store_item_name) }
    private val details by lazy<TextView> { itemView.findViewById(R.id.store_item_details) }
    private val deliveryTime by lazy<TextView> { itemView.findViewById(R.id.store_item_delivery_time) }
    private val deliveryPrice by lazy<TextView> { itemView.findViewById(R.id.store_item_delivery_price) }
    private val ratings by lazy<TextView> { itemView.findViewById(R.id.store_item_delivery_ratings) }

    fun bind(storeItem: StoreItem) {
        if (storeItem.headerUrl.isNotBlank()) {
            headerImage.scaleType = ImageView.ScaleType.CENTER_CROP
            headerImage.load(storeItem.headerUrl)
        } else {
            headerImage.scaleType = ImageView.ScaleType.FIT_CENTER
            headerImage.load(storeItem.coverUrl)
        }
        name.text = storeItem.name
        details.text = storeItem.details
        deliveryTime.text = storeItem.deliveryTime
        deliveryPrice.text = storeItem.deliveryPrice
        ratings.text = itemView.context
            .getString(R.string.ratings_format, storeItem.rating, storeItem.ratingQuantity)
    }
}