package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.core_util.ticker.Ticker
import com.sillyapps.timedoser.domain.DayDataSource
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.logic.day.pause
import com.sillyapps.timedoser.domain.model.Day
import javax.inject.Inject

class PauseDayUseCase @Inject constructor(
  private val repository: DayRepository,
  private val ticker: Ticker,
  private val dayDataSource: DayDataSource
) {

  operator fun invoke() {
    val day = dayDataSource.get()
    if (day.state != Day.State.ACTIVE)
      return

    dayDataSource.modify { it.pause() }

    ticker.stop()
  }
}