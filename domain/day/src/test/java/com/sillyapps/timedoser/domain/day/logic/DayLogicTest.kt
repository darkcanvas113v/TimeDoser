package com.sillyapps.timedoser.domain.day.logic

import com.google.common.truth.Truth.assertThat
import com.sillyapps.core_time.Time
import com.sillyapps.timedoser.domain.day.models.DayMockModelBuilder
import com.sillyapps.timedoser.domain.logic.day.pause
import com.sillyapps.timedoser.domain.logic.day.setNewTask
import com.sillyapps.timedoser.domain.logic.task.completeTask
import com.sillyapps.timedoser.domain.logic.task.pause
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.mutable.MutableTask
import org.junit.Test

class DayLogicTest {
  @Test
  fun testDayPause() {
    val input = DayMockModelBuilder()
      .addTask(duration = 5 * Time.m)
      .setDayState(state = Day.State.ACTIVE)
      .build()

    val expectedTasks = input.tasks.map { it.copy() }

    expectedTasks[0].pause()

    input.pause()

    assertThat(input.state).isEqualTo(Day.State.DISABLED)
    assertThat(input.tasks).containsExactlyElementsIn(expectedTasks)
  }

  @Test
  fun testSetNewTask_ThenEveryTaskIsDisabled() {
    val input = DayMockModelBuilder()
      .addTask(duration = 5 * Time.m, times = 3)
      .disableTask(1)
      .disableTask(2)
      .setDayState(Day.State.ACTIVE)
      .build()

    val expectedTasks = input.tasks.map { it.copy() }
    expectedTasks.forEach { it.completeTask() }

    input.setNewTask()

    assertThat(input.state).isEqualTo(Day.State.COMPLETED)
    assertThat(input.currentTaskPos).isEqualTo(2)

    assertThat(input.tasks).containsExactlyElementsIn(expectedTasks)
  }
}