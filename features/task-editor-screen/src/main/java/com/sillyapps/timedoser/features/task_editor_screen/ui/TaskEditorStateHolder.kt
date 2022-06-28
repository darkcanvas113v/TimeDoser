package com.sillyapps.timedoser.features.task_editor_screen.ui

import com.sillyapps.timedoser.features.task_editor_screen.models.TaskEditorModel
import kotlinx.coroutines.flow.Flow

interface TaskEditorStateHolder {
  fun getTask(): Flow<TaskEditorModel>

  fun setName(name: String)

  fun setDuration(duration: Long)

  fun save()

  fun taskIsValid(): Boolean
}