package com.sillyapps.core_util.ticker

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

class CoroutineTicker @Inject constructor(): Ticker {

  private val events = MutableSharedFlow<Unit>()

  private var counter: Job? = null

  override fun getTickerEvents(): Flow<Unit> {
    return events
  }

  override fun start(interval: Long) {
    counter = CoroutineScope(Dispatchers.Default).launch {
      events.emit(Unit)
      delay(interval)
    }
  }

  override fun stop() {
    counter?.cancel()
  }


}