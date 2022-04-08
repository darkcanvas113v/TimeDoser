package com.sillyapps.timedoser.data.day

import com.sillyapps.core.di.IODispatcher
import com.sillyapps.timedoser.data.day.model.toDay
import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.template.TemplateRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DayRepositoryImpl @Inject constructor(
  @IODispatcher private val ioDispatcher: CoroutineDispatcher,
  private val dayDataSource: DayDataSource,
  private val templateRepository: TemplateRepository
): DayRepository {
  override suspend fun getDay(): DataState<Day> = withContext(ioDispatcher) {
    val template = templateRepository.getDefaultTemplate()?.toDay()

    if (template == null) DataState.Empty()
    else DataState.Success(template)
  }

  override suspend fun saveDay(day: Day) = withContext(ioDispatcher) {

  }


}