package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.core.di.AppScope
import com.sillyapps.core_util.ticker.Ticker
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.logic.day.start
import com.sillyapps.timedoser.domain.logic.day.tick
import com.sillyapps.timedoser.domain.model.Day
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class StartDayUseCase @Inject constructor(
  private val repository: DayRepository,
  private val ticker: Ticker,
  private val appScope: CoroutineScope
) {

  suspend operator fun invoke() {
    val day = repository.getDayRaw()

    if (day.tasks.isEmpty())
      return

    //TODO сделать глобальный объект который будет следить за тикером
    if (day.state == Day.State.WAITING)
      appScope.launch {
        ticker.getTickerEvents().collect {
          progress()
        }
      }

    ticker.start(1000L)

    repository.setDay(day.start())
  }

  private suspend fun progress() {
    val day = repository.getDayRaw().tick()

    if (day.state != Day.State.ACTIVE)
      ticker.stop()

    repository.setDay(day)
  }
}