package com.sillyapps.core_util.ticker

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

class CoroutineTicker @Inject constructor(): Ticker {

  private val ticks = MutableSharedFlow<Long>()

  private var counter: Job? = null

  private var lastUpdateTime = 0L

  override fun getTicks(): Flow<Long> {
    return ticks
  }

  override fun start(interval: Long) {
    lastUpdateTime = System.currentTimeMillis()

    counter = CoroutineScope(Dispatchers.Default).launch {
      while (true) {
        ticks.emit(System.currentTimeMillis() - lastUpdateTime)
        lastUpdateTime = System.currentTimeMillis()
        delay(interval)
      }
    }
  }

  override fun stop() {
    counter?.cancel()
  }

}