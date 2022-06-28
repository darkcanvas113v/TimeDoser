package com.sillyapps.timedoser.data.day

import com.sillyapps.core.di.IODispatcher
import com.sillyapps.timedoser.data.day.model.toDataModel
import com.sillyapps.timedoser.data.day.model.toDay
import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.template.TemplateRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DayRepositoryImpl @Inject constructor(
  @IODispatcher private val ioDispatcher: CoroutineDispatcher,
  private val dayDataSource: DayDataSource,
  private val templateRepository: TemplateRepository
): DayRepository {

  private val status = MutableStateFlow<DataState<Day>>(DataState.InitialState())

  private val state = status.combine(dayDataSource.get()) { status, day ->
    when (status) {
      is DataState.Success -> DataState.Success(day)
      else -> status
    }
  }

  override fun getDay(): Flow<DataState<Day>> = state

  override suspend fun setDay(day: Day) {
    dayDataSource.set(day)
  }

  override suspend fun getDayRaw(): Day {
    return dayDataSource.getRaw()
  }

  override suspend fun load() {
    if (status.value !is DataState.InitialState) return

    val day = templateRepository.getDefaultTemplate()?.toDay()

    dayDataSource.set(day ?: Day.EMPTY)
    status.value = DataState.Success(Day.EMPTY)
  }

  override suspend fun saveDay() = withContext(ioDispatcher) {
    dayDataSource.save()
  }

}