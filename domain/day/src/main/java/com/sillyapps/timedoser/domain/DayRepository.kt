package com.sillyapps.timedoser.domain

import com.sillyapps.timedoser.domain.model.Day

interface DayRepository {

  suspend fun getDay(): DataState<Day>

  suspend fun saveDay(day: Day)

}