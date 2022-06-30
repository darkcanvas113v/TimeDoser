package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.core_util.ticker.Ticker
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.logic.day.pause
import com.sillyapps.timedoser.domain.model.Day
import javax.inject.Inject

class PauseDayUseCase @Inject constructor(
  private val repository: DayRepository,
  private val ticker: Ticker
) {

  suspend operator fun invoke() {
    val day = repository.getDayRaw()
    if (day.state != Day.State.ACTIVE)
      return

    repository.setDay(day.pause())

    ticker.stop()
  }
}