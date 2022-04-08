package com.sillyapps.timedoser.data.day

import com.sillyapps.timedoser.data.day.model.DayDataModel
import com.sillyapps.timedoser.domain.model.Day

interface DayDataSource {

  fun saveDay(day: DayDataModel)

  fun loadDay(): DayDataModel?

}