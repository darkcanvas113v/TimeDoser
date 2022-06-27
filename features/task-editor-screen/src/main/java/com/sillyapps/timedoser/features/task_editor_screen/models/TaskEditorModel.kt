package com.sillyapps.timedoser.features.task_editor_screen.models

import com.sillyapps.timedoser.domain.model.RunningTask

data class TaskEditorModel(
  val duration: Long,
  val name: String,
  val state: Int,
  val progress: Long
) {
  companion object {
    val DEFAULT_VALUE = TaskEditorModel(
      duration = 0L,
      name = "",
      state = 0,
      progress = 0L
    )
  }
}

fun RunningTask.toUIModel(): TaskEditorModel {
  return TaskEditorModel(
    duration = duration,
    name = name,
    state = state.ordinal,
    progress = progress
  )
}

fun TaskEditorModel.toDomainModel(): RunningTask {
  return RunningTask(
    startTime = 0L,
    state = RunningTask.State.WAITING,
    progress = progress,
    duration = duration,
    name = name
  )
}