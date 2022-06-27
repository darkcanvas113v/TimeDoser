package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.logic.day.setTask
import com.sillyapps.timedoser.domain.model.RunningTask
import javax.inject.Inject

class SetTaskAtPositionUseCase @Inject constructor(
  private val repository: DayRepository
) {

  suspend operator fun invoke(pos: Int, task: RunningTask) {
    val day = repository.getDayRaw()
    repository.setDay(day.setTask(pos, task))
  }

}