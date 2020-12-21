package com.gabilheri.doordashchallenge.stores.ui

import com.gabilheri.doordashchallenge.stores.data.StoreItem

sealed class StoreListState {
    data class Display(val items: List<StoreItem>): StoreListState()
    data class Error(val errorMessage: String): StoreListState()
    object Loading : StoreListState()
}