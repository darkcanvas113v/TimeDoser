package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.timedoser.domain.DayRepository
import javax.inject.Inject

class LoadDayUseCase @Inject constructor(
  private val repository: DayRepository
) {

  suspend operator fun invoke() {
    repository.load()
  }
}