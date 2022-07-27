package com.sillyapps.timedoser.domain.model.mutable

import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask

data class MutableDay(
  var name: String,
  var templateId: Long,
  val tasks: MutableList<MutableTask>,
  var state: Day.State,
  var currentTaskPos: Int
)

internal fun MutableDay.toDay() = Day(
  name = name,
  templateId = templateId,
  tasks = tasks.map { it.toRunningTask() },
  state = state,
  currentTaskPos = currentTaskPos
)