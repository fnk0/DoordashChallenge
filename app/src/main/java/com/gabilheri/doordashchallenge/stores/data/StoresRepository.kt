package com.gabilheri.doordashchallenge.stores.data

import com.gabilheri.doordashchallenge.network.DoorDashApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

private const val LAT = 37.422740
private const val LNG = -122.139956

class StoresRepository @Inject constructor(
    private val api: DoorDashApi,
    private val storeItemFactory: StoreItemFactory
) {

    fun getStoreItems(offset: Int): Single<List<StoreItem>> {
        return api.getStores(lat = LAT, lng = LNG, offset = offset)
            .map { response ->
                response.stores.map { store ->
                    storeItemFactory.create(store)
                }
            }
    }
}