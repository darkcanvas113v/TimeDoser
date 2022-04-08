package com.sillyapps.core_util.ticker

import kotlinx.coroutines.flow.Flow

interface Ticker {

  fun getTickerEvents(): Flow<Unit>

  fun start(interval: Long)

  fun stop()

}