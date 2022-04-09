package com.sillyapps.timedoser.main_screen.model

import com.sillyapps.core_time.convertMillisToStringFormat
import com.sillyapps.core_time.convertMillisToStringFormatWithSeconds
import com.sillyapps.timedoser.domain.model.RunningTask

data class TaskUIModel(
  val startTime: String,
  val duration: Long,
  val name: String,
  val state: RunningTask.State,
  val progress: String,
  val relativeProgress: Float,
  val timeRemained: String
)

fun RunningTask.toUIModel(): TaskUIModel {
  val timeRemained = duration - progress

  return TaskUIModel(
    startTime = convertMillisToStringFormat(startTime),
    duration = duration,
    name = name,
    state = state,
    progress = convertMillisToStringFormatWithSeconds(progress),
    timeRemained = convertMillisToStringFormatWithSeconds(timeRemained),
    relativeProgress = timeRemained.toFloat() / duration,
  )
}