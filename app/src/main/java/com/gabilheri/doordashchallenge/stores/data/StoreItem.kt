package com.gabilheri.doordashchallenge.stores.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreItem(
    val id: Int,
    val name: String,
    val headerUrl: String,
    val coverUrl: String,
    val details: String,
    val deliveryPrice: String,
    val deliveryTime: String,
    val rating: String,
    val ratingQuantity: String
): Parcelable
