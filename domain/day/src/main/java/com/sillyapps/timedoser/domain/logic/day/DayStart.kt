package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.logic.task.taskStart
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.mutable.MutableDay

internal fun MutableDay.start() {
  if (tasks.isEmpty()) return

  val currentTime = System.currentTimeMillis()
  tasks[currentTaskPos].taskStart(currentTime)
  state = Day.State.ACTIVE
}