package com.gabilheri.doordashchallenge.stores.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabilheri.doordashchallenge.R
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoresFragment : Fragment() {

    private val storesListView: RecyclerView by lazy {
        requireNotNull(view).findViewById(R.id.stores_list)
    }
    private val progressBar: ProgressBar by lazy {
        requireNotNull(view).findViewById(R.id.progress_bar)
    }

    private val viewModel: StoresViewModel by viewModels()
    private val adapter = StoresAdapter()
    private val layoutManager by lazy { LinearLayoutManager(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stores, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storesListView.layoutManager = layoutManager
        storesListView.adapter = adapter
        observeStoreItems()
        viewModel.updateStores()
    }

    private fun observeStoreItems() {
        viewModel.storeItems.observe(viewLifecycleOwner) { renderState(state = it) }
    }

    private fun renderState(state: StoreListState) {
        when(state) {
            is StoreListState.Display -> {
                progressBar.isVisible = false
                adapter.submitList(state.items)
            }
            is StoreListState.Loading -> {
                progressBar.isVisible = true
            }
            is StoreListState.Error -> {
                progressBar.isVisible = false
                showErrorSnackBar(state.errorMessage)
            }
        }
    }

    private fun showErrorSnackBar(errorMessage: String) {
        val snackBar = Snackbar.make(requireView(), errorMessage, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(getString(R.string.retry)) {
            viewModel.updateStores()
            snackBar.dismiss()
        }
        snackBar.show()
    }
}