package com.sillyapps.timedoser.domain

import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.mutable.MutableDay
import kotlinx.coroutines.flow.Flow

interface DayDataSource {

  fun get(): Day

  fun modify(modifyBlock: (MutableDay) -> Unit)

  fun set(day: Day)

  fun getDay(): Flow<DataState<Day>>

}