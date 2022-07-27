package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.core_util.ticker.Ticker
import com.sillyapps.timedoser.domain.DayDataSource
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.logic.day.setNewTask
import com.sillyapps.timedoser.domain.model.Day
import javax.inject.Inject

class StopDayUseCase @Inject constructor(
  private val repository: DayRepository,
  private val ticker: Ticker,
  private val dayDataSource: DayDataSource
) {

  operator fun invoke() {
    dayDataSource.modify { day ->
      if (day.state != Day.State.ACTIVE)
        return@modify

      day.setNewTask()

      if (day.state == Day.State.COMPLETED) {
        ticker.stop()
      }
    }
  }
}