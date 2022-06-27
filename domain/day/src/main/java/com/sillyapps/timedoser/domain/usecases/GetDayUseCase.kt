package com.sillyapps.timedoser.domain.usecases

import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.model.Day
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetDayUseCase @Inject constructor(
  private val repository: DayRepository
) {

  operator fun invoke(): Flow<DataState<Day>> {
    return repository.getDay()
  }
}