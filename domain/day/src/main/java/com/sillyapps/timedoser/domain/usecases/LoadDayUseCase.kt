package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.timedoser.domain.DayDataSource
import com.sillyapps.timedoser.domain.DayRepository
import javax.inject.Inject

class LoadDayUseCase @Inject constructor(
  private val repository: DayRepository,
  private val dayDataSource: DayDataSource
) {

  suspend operator fun invoke() {
    repository.load()
    val day = repository.getDayRaw()

    dayDataSource.set(day)
  }
}