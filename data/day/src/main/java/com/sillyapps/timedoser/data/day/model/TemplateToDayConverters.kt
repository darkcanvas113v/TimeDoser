package com.sillyapps.timedoser.data.day.model

import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.domain.template.model.Task
import com.sillyapps.timedoser.domain.template.model.Template

fun Template.toDay(): Day {
  return Day(
    name = name,
    templateId = id,
    tasks = tasks.map { it.toRunningTask() },
    state = Day.State.WAITING,
    currentTaskPos = 0
  )
}

fun Task.toRunningTask(): RunningTask {
  return RunningTask(
    startTime = startTime,
    duration = duration,
    name = name,
    state = RunningTask.State.WAITING,
    progress = 0L
  )
}