package com.gabilheri.doordashchallenge.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DoorDashApi {

    @GET("/v1/store_feed")
    fun getStores(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 50
    ): Single<DoorDashResponse>
}