package com.sillyapps.timedoser.data.day

import com.sillyapps.timedoser.data.day.model.DayDataModel
import com.sillyapps.timedoser.domain.model.Day
import kotlinx.coroutines.flow.Flow

interface DayDataSource {

  fun get(): Flow<Day>

  fun getRaw(): Day

  fun set(day: Day)

  fun save()

  fun load()

}