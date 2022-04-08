package com.sillyapps.core_util.ticker

import dagger.Binds
import dagger.Module

@Module
interface TickerModule {

  @Binds
  fun bindTicker(ticker: CoroutineTicker): Ticker

}