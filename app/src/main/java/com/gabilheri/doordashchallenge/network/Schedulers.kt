package com.gabilheri.doordashchallenge.network

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

interface Schedulers {
    val io: Scheduler
    val mainThread: Scheduler
}

object DefaultSchedulers : com.gabilheri.doordashchallenge.network.Schedulers {
    override val io = requireNotNull(Schedulers.io())
    override val mainThread = requireNotNull(AndroidSchedulers.mainThread())
}