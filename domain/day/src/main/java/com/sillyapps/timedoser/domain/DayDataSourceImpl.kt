package com.sillyapps.timedoser.domain

import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.mutable.MutableDay
import com.sillyapps.timedoser.domain.model.mutable.toDay
import com.sillyapps.timedoser.domain.model.mutable.toMutableTask
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DayDataSourceImpl @Inject constructor(): DayDataSource {

  private val model = MutableDay(
    name = "",
    templateId = 0L,
    tasks = mutableListOf(),
    state = Day.State.WAITING,
    currentTaskPos = 0
  )

  private val flow = MutableSharedFlow<MutableDay>(
    replay = 1,
    onBufferOverflow = BufferOverflow.DROP_OLDEST
  )

  init {
    flow.tryEmit(model)
  }

  override fun get(): Day {
    return model.toDay()
  }

  override fun modify(modifyBlock: (MutableDay) -> Unit) {
    modifyBlock(model)
    flow.tryEmit(model)
  }

  override fun set(day: Day) {
    model.apply {
      name = day.name
      templateId = day.templateId

      tasks.clear()
      tasks.addAll(day.tasks.map { it.toMutableTask() })

      state = day.state
      currentTaskPos = day.currentTaskPos
    }
  }

  override fun getDay(): Flow<DataState<Day>> {
    return flow.map { DataState.Success(it.toDay()) }
  }

}