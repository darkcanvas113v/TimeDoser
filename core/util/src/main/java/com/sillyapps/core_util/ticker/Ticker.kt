package com.sillyapps.core_util.ticker

import kotlinx.coroutines.flow.Flow

interface Ticker {

  fun getTicks(): Flow<Long>

  fun start(interval: Long)

  fun stop()

}