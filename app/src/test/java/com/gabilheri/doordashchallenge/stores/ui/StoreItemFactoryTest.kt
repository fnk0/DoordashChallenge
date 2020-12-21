package com.gabilheri.doordashchallenge.stores.ui

import com.gabilheri.doordashchallenge.network.DoorDashStore
import com.gabilheri.doordashchallenge.stores.data.StoreItem
import com.gabilheri.doordashchallenge.stores.data.StoreItemFactory
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class StoreItemFactoryTest {

    private val factory = StoreItemFactory()

    @Test
    fun `create - given DoorDashStore - should return StoreItem`() {
        // given
        val store = DoorDashStore(
            id = 320,
            name = "Foo",
            description = "Description",
            priceRange = 2,
            displayDeliveryFee = "Free Delivery",
            averageRating = 4.3f,
            coverImageUrl = "coverUrl",
            headerImageUrl = "headerUrl",
            numRatings = 376,
            isNewlyAdded = false,
            status = DoorDashStore.Status(
                unavailableReason = null,
                asapAvailable = true,
                pickupAvailable = true,
                asapMinutesRange = listOf(16, 20)
            ),
            distanceFromConsumer = 0.11
        )
        val item = StoreItem(
            id = 320,
            name = "Foo",
            details = "$$ - Description",
            deliveryPrice = "Free Delivery",
            coverUrl = "coverUrl",
            headerUrl = "headerUrl",
            rating = "4.3",
            ratingQuantity = "376",
            deliveryTime = "18 Mins"
        )

        // when
        val result = factory.create(store)

        // then
        assertThat(result).isEqualTo(item)
    }
}