package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.logic.day.setNewTask
import com.sillyapps.timedoser.domain.model.Day
import javax.inject.Inject

class StopDayUseCase @Inject constructor(
  private val repository: DayRepository
) {

  suspend operator fun invoke() {
    val day = repository.getDayRaw()
    if (day.state != Day.State.ACTIVE)
      return

    repository.setDay(day.setNewTask())
  }
}