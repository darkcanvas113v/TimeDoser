package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.logic.task.pause
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.mutable.MutableDay

internal fun MutableDay.pause() {
  tasks[currentTaskPos].pause()
  state = Day.State.DISABLED
}