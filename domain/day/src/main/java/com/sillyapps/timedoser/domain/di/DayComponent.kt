package com.sillyapps.timedoser.domain.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.core_util.ticker.CoroutineTicker
import com.sillyapps.core_util.ticker.Ticker
import com.sillyapps.timedoser.domain.DayDataSource
import com.sillyapps.timedoser.domain.DayDataSourceImpl
import com.sillyapps.timedoser.domain.DayProgressWatcher
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.usecases.*
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import kotlinx.coroutines.CoroutineScope

@AppScope
@Component(modules = [TickerModule::class, DataSourceModule::class])
interface DayComponent {

  fun getDayUseCase(): GetDayUseCase
  fun getTaskAtPositionUseCase(): GetTaskAtPositionUseCase
  fun loadDayUseCase(): LoadDayUseCase
  fun pauseDayUseCase(): PauseDayUseCase
  fun setTaskAtPosUseCase(): SetTaskAtPositionUseCase
  fun startDayUseCase(): StartDayUseCase
  fun stopDayUseCase(): StopDayUseCase

  fun getDayProgressWatcher(): DayProgressWatcher

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

@Module
internal interface DataSourceModule {

  @AppScope
  @Binds
  fun bindDayDataSource(dataSourceImpl: DayDataSourceImpl): DayDataSource

}