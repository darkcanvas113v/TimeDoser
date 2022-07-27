package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.timedoser.domain.DayDataSource
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.logic.day.setTask
import com.sillyapps.timedoser.domain.model.RunningTask
import javax.inject.Inject

class SetTaskAtPositionUseCase @Inject constructor(
  private val dayDataSource: DayDataSource
) {

  operator fun invoke(pos: Int, task: RunningTask) {
    dayDataSource.modify {
      it.setTask(pos, task)
    }
  }

}