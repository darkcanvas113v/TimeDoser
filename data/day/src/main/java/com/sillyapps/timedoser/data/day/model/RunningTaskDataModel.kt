package com.sillyapps.timedoser.data.day.model

import com.sillyapps.timedoser.domain.model.RunningTask
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RunningTaskDataModel(
  val startTime: Long,
  val duration: Long,
  val name: String,
  val state: RunningTask.State,
  val progress: Long
)

fun RunningTaskDataModel.toDomainModel(): RunningTask {
  return RunningTask(
    startTime = startTime,
    duration = duration,
    name = name,
    state = state,
    progress = progress
  )
}

fun RunningTask.toDataModel(): RunningTaskDataModel {
  return RunningTaskDataModel(
    startTime = startTime,
    duration = duration,
    name = name,
    state = state,
    progress = progress
  )
}