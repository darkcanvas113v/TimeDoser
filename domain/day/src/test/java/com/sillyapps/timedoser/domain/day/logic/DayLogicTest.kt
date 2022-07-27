package com.sillyapps.timedoser.domain.day.logic

import com.google.common.truth.Truth.assertThat
import com.sillyapps.core_time.Time
import com.sillyapps.timedoser.domain.day.models.DayMockModelBuilder
import com.sillyapps.timedoser.domain.logic.day.pause
import com.sillyapps.timedoser.domain.logic.day.setNewTask
import com.sillyapps.timedoser.domain.logic.task.completeTask
import com.sillyapps.timedoser.domain.logic.task.pause
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask
import org.junit.Test

class DayLogicTest {
  @Test
  fun testDayPause() {
    val input = DayMockModelBuilder()
      .addTask(duration = 5 * Time.m)
      .setDayState(state = Day.State.ACTIVE)
      .build()

    val tasksCopy = mutableListOf<RunningTask>()
    tasksCopy.addAll(input.tasks)

    tasksCopy[0] = tasksCopy[0].pause()

    val output = input.pause()

    assertThat(output.state).isEqualTo(Day.State.DISABLED)
    assertThat(output.tasks).containsExactlyElementsIn(tasksCopy)
  }

  @Test
  fun testSetNewTask_ThenEveryTaskIsDisabled() {
    val input = DayMockModelBuilder()
      .addTask(duration = 5 * Time.m, times = 3)
      .disableTask(1)
      .disableTask(2)
      .setDayState(Day.State.ACTIVE)
      .build()

    val output = input.setNewTask()

    assertThat(output.state).isEqualTo(Day.State.COMPLETED)
    assertThat(output.currentTaskPos).isEqualTo(2)

    val expectedTasks = input.tasks.map {
      it.completeTask()
    }
    assertThat(output.tasks).containsExactlyElementsIn(expectedTasks)
  }
}