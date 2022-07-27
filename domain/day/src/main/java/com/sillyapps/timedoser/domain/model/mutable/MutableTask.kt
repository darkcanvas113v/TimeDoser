package com.sillyapps.timedoser.domain.model.mutable

import com.sillyapps.timedoser.domain.model.RunningTask

data class MutableTask(
  var startTime: Long,
  var duration: Long,
  var name: String,
  var state: RunningTask.State,
  var progress: Long
)

internal fun MutableTask.toRunningTask() = RunningTask(
  startTime = startTime,
  duration = duration,
  name = name,
  state = state,
  progress = progress
)

internal fun RunningTask.toMutableTask() = MutableTask(
  startTime = startTime,
  duration = duration,
  name = name,
  state = state,
  progress = progress
)