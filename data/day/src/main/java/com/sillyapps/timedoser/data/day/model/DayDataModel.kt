package com.sillyapps.timedoser.data.day.model

import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.domain.template.model.Template
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DayDataModel(
  val name: String,
  val templateId: Long,
  val tasks: List<RunningTaskDataModel>,
  val state: Day.State,
  val currentTaskPos: Int
)

fun DayDataModel.toDomainModel(): Day {
  return Day(
    name = name,
    templateId = templateId,
    tasks = tasks.map { it.toDomainModel() },
    state = state,
    currentTaskPos = currentTaskPos
  )
}

fun Day.toDataModel(): DayDataModel {
  return DayDataModel(
    name = name,
    templateId = templateId,
    tasks = tasks.map { it.toDataModel() },
    state = state,
    currentTaskPos = currentTaskPos
  )
}