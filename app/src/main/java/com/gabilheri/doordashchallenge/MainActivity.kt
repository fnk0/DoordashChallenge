package com.gabilheri.doordashchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabilheri.doordashchallenge.stores.ui.StoresFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val stores = StoresFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, stores)
            .commitNow()
    }
}