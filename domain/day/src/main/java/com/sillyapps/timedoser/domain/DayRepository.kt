package com.sillyapps.timedoser.domain

import com.sillyapps.timedoser.domain.model.Day
import kotlinx.coroutines.flow.Flow

interface DayRepository {

  fun getDay(): Flow<DataState<Day>>

  suspend fun setDay(day: Day)
  suspend fun getDayRaw(): Day

  suspend fun load()

  suspend fun saveDay()

}