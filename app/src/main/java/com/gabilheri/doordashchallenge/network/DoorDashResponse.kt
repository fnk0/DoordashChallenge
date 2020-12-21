package com.gabilheri.doordashchallenge.network

import com.squareup.moshi.Json

data class DoorDashResponse(
    @Json(name = "num_results") val numResults: Int,
    @Json(name = "next_offset") val nextOffset: Int,
    @Json(name = "show_list_as_pickup") val showListAsPickup: Boolean,
    @Json(name = "stores") val stores: List<DoorDashStore>,
)

data class DoorDashStore(
    @Json(name = "business_id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "is_newly_added") val isNewlyAdded: Boolean,
    @Json(name = "average_rating") val averageRating: Float,
    @Json(name = "num_ratings") val numRatings: Int,
    @Json(name = "description") val description: String,
    @Json(name = "cover_img_url") val coverImageUrl: String,
    @Json(name = "header_img_url") val headerImageUrl: String,
    @Json(name = "price_range") val priceRange: Int,
    @Json(name = "display_delivery_fee") val displayDeliveryFee: String,
    @Json(name = "distance_from_consumer") val distanceFromConsumer: Double,
    @Json(name = "status") val status: Status
) {
    data class Status(
        @Json(name = "unavailable_reason") val unavailableReason: String?,
        @Json(name = "asap_available") val asapAvailable: Boolean,
        @Json(name = "pickup_available") val pickupAvailable: Boolean,
        @Json(name = "asap_minutes_range") val asapMinutesRange: List<Int>
    )
}