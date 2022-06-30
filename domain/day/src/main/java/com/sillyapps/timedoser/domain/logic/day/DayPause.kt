package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.logic.task.pause
import com.sillyapps.timedoser.domain.model.Day

internal fun Day.pause(): Day {
  val mutTasks = tasks.toMutableList()

  mutTasks[currentTaskPos] = mutTasks[currentTaskPos].pause()

  return this.copy(
    state = Day.State.DISABLED,
    tasks = mutTasks
  )
}