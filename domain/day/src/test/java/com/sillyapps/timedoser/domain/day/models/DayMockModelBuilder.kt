package com.sillyapps.timedoser.domain.day.models

import com.sillyapps.timedoser.domain.logic.task.completeTask
import com.sillyapps.timedoser.domain.logic.task.disable
import com.sillyapps.timedoser.domain.logic.task.getEndTime
import com.sillyapps.timedoser.domain.logic.task.pause
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.domain.model.mutable.MutableDay
import com.sillyapps.timedoser.domain.model.mutable.MutableTask
import dagger.Component
import java.lang.Error
import java.lang.Exception

@Component.Builder
class DayMockModelBuilder {

  private var name: String = "Day"
  private var currentTaskPosition: Int = 0
  private var state: Day.State? = null
  private val tasks: MutableList<MutableTask> = mutableListOf()


  fun addTask(
    duration: Long,
    name: String = "Task",
    times: Int = 1
  ): DayMockModelBuilder {
    for (i in 0 until times) {
      val startTime = tasks.lastOrNull()?.getEndTime() ?: 0L

      tasks.add(
        MutableTask(
          duration = duration,
          name = name,
          progress = 0L,
          startTime = startTime,
          state = RunningTask.State.WAITING
        )
      )
    }

    return this
  }

  fun setCurrentTaskPos(
    currentTaskPos: Int = 0,
    progress: Long = 0
  ): DayMockModelBuilder {
    currentTaskPosition = if (tasks.size >= currentTaskPos) {
      println("Index out of bounds! Current task index is set to be $currentTaskPos, while tasks.size is ${tasks.size}")
      if (tasks.size == 0) {
        throw Error("No tasks added!")
      }
      println("Setting currentTaskPos to tasks last index...")
      tasks.lastIndex
    } else
      currentTaskPos

    for (i in 0 until currentTaskPosition) {
      tasks[i].completeTask()
    }

    tasks[currentTaskPosition].apply {
      this.progress = progress
      state = RunningTask.State.WAITING
    }

    return this
  }

  fun disableTask(
    taskPos: Int
  ): DayMockModelBuilder {
    if (taskPos < currentTaskPosition) {
      println("Can't set task as disabled. Skipping...")
      return this
    }
    tasks[taskPos].disable()

    return this
  }

  fun setDayState(
    state: Day.State
  ): DayMockModelBuilder {
    if (this.state != null) {
      return this
    }

    val currentTask = tasks[currentTaskPosition]
    this.state = state
    when (state) {
      Day.State.ACTIVE -> {
        currentTask.apply { this.state = RunningTask.State.ACTIVE }
      }
      Day.State.WAITING -> {

      }
      Day.State.COMPLETED -> {
        for (i in currentTaskPosition until tasks.size) {
          tasks[i].completeTask()
        }
        currentTaskPosition = tasks.lastIndex
      }
      Day.State.DISABLED -> {
        tasks[currentTaskPosition].pause()
      }
    }
    return this
  }

  fun setName(name: String): DayMockModelBuilder {
    this.name = name
    return this
  }

  fun build(): MutableDay {
    if (state == null) state = Day.State.WAITING

    return MutableDay(
      name = name,
      currentTaskPos = currentTaskPosition,
      state = state!!,
      tasks = tasks,
      templateId = 0
    )
  }

}