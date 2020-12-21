package com.gabilheri.doordashchallenge

import com.gabilheri.doordashchallenge.network.Schedulers
import io.reactivex.rxjava3.core.Scheduler

private typealias RxSchedulers = io.reactivex.rxjava3.schedulers.Schedulers

object TestSchedulers : Schedulers{
    override val io: Scheduler = RxSchedulers.trampoline()
    override val mainThread: Scheduler = RxSchedulers.trampoline()
}