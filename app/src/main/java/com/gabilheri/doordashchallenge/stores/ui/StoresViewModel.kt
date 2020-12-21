package com.gabilheri.doordashchallenge.stores.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gabilheri.doordashchallenge.network.Schedulers
import com.gabilheri.doordashchallenge.stores.data.StoresRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import timber.log.Timber

class StoresViewModel @ViewModelInject constructor(
    private val repository: StoresRepository,
    private val schedulers: Schedulers
) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val _storeItems = MutableLiveData<StoreListState>()

    val storeItems: LiveData<StoreListState> = _storeItems

    fun updateStores() {
        repository.getStoreItems(offset = 0)
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.mainThread)
            .doOnSubscribe { _storeItems.value = StoreListState.Loading }
            .subscribeBy(
                onSuccess = { storeItems ->
                    _storeItems.value = StoreListState.Display(storeItems)
                },
                onError = { error ->
                    Timber.e(error)
                    _storeItems.value = StoreListState.Error(errorMessage = "Oops! Something went wrong.")
                }
            )
            .also { disposables.add(it) }
    }
}