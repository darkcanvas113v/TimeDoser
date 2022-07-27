package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.DayDataSource
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskAtPositionUseCase @Inject constructor(
  private val dayDataSource: DayDataSource
) {

  operator fun invoke(pos: Int): RunningTask? {
    if (pos == -1) return null
    return dayDataSource.get().tasks[pos]
  }

}