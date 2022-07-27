package com.sillyapps.timedoser.domain.logic.task

import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.domain.model.mutable.MutableTask

internal fun MutableTask.completeTask() {
  state = RunningTask.State.COMPLETED
  duration = progress
}