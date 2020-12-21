package com.gabilheri.doordashchallenge.stores.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.gabilheri.doordashchallenge.TestSchedulers
import com.gabilheri.doordashchallenge.stores.data.StoreItem
import com.gabilheri.doordashchallenge.stores.data.StoresRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.Rule
import org.junit.Test
import java.lang.RuntimeException

class StoresViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    private val repository = mockk<StoresRepository>()
    private val schedulers = TestSchedulers
    private val viewModel = StoresViewModel(repository, schedulers)

    @Test
    fun `updateStores - given success response - should load and emit display state`() {
        // given
        val items = listOf<StoreItem>(mockk())
        every { repository.getStoreItems(offset = 0) } returns Single.just(items)

        val states = mutableListOf<StoreListState>()
        val observer = Observer<StoreListState> { states.add(it) }
        viewModel.storeItems.observeForever(observer)

        // when
        viewModel.updateStores()

        // then
        assertThat(states).isEqualTo(
            listOf(
                StoreListState.Loading,
                StoreListState.Display(items)
            )
        )
        viewModel.storeItems.removeObserver(observer)
    }

    @Test
    fun `updateStores - given error response - should load and emit error state`() {
        // given
        val error = RuntimeException("Some Error")
        every { repository.getStoreItems(offset = 0) } returns Single.error(error)

        val states = mutableListOf<StoreListState>()
        val observer = Observer<StoreListState> { states.add(it) }
        viewModel.storeItems.observeForever(observer)

        // when
        viewModel.updateStores()

        // then
        assertThat(states).isEqualTo(
            listOf(
                StoreListState.Loading,
                StoreListState.Error(errorMessage = "Oops! Something went wrong.")
            )
        )
        viewModel.storeItems.removeObserver(observer)
    }

}