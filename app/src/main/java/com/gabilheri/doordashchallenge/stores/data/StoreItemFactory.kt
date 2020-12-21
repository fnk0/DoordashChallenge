package com.gabilheri.doordashchallenge.stores.data

import com.gabilheri.doordashchallenge.network.DoorDashStore

class StoreItemFactory {

    fun create(store: DoorDashStore): StoreItem {
        return StoreItem(
            id = store.id,
            name = store.name,
            details = "${createDeliveryPriceString(store.priceRange)} - ${store.description}",
            deliveryPrice = store.displayDeliveryFee,
            coverUrl = store.coverImageUrl,
            headerUrl = store.headerImageUrl,
            rating = "${store.averageRating}",
            ratingQuantity = "${store.numRatings}",
            deliveryTime = "${createDeliveryTime(store.status.asapMinutesRange)} Mins"
        )
    }

    private fun createDeliveryPriceString(priceRange: Int): String {
        return (0 until priceRange).map { "$" }.reduce { acc, s -> acc + s }
    }

    private fun createDeliveryTime(ranges: List<Int>): Int {
        return ranges.average().toInt()
    }
}