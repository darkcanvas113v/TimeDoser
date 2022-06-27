package com.sillyapps.timedoser.domain.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.core_util.ticker.CoroutineTicker
import com.sillyapps.core_util.ticker.Ticker
import com.sillyapps.timedoser.domain.DayRepository
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import kotlinx.coroutines.CoroutineScope

@AppScope
@Component(modules = [TickerModule::class])
interface DayComponent {

  fun getRepository(): DayRepository

  fun getTicker(): Ticker

  fun getAppScope(): CoroutineScope

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun repository(repo: DayRepository): Builder

    @BindsInstance
    fun appScope(scope: CoroutineScope): Builder

    fun build(): DayComponent
  }
}

@Module
interface TickerModule {

  @AppScope
  @Binds
  fun bindDayTicker(ticker: CoroutineTicker): Ticker

}