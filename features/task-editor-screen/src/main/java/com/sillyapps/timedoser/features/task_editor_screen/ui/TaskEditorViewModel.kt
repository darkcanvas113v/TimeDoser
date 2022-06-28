package com.sillyapps.timedoser.features.task_editor_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.usecases.GetTaskAtPositionUseCase
import com.sillyapps.timedoser.domain.usecases.SetTaskAtPositionUseCase
import com.sillyapps.timedoser.features.task_editor_screen.di.TaskPosition
import com.sillyapps.timedoser.features.task_editor_screen.models.TaskEditorModel
import com.sillyapps.timedoser.features.task_editor_screen.models.toDomainModel
import com.sillyapps.timedoser.features.task_editor_screen.models.toUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskEditorViewModel @Inject constructor(
  @TaskPosition private val taskPosition: Int,
  private val getTaskAtPositionUseCase: GetTaskAtPositionUseCase,
  private val setTaskAtPositionUseCase: SetTaskAtPositionUseCase
): ViewModel(), TaskEditorStateHolder {

  private val task = MutableStateFlow(TaskEditorModel.DEFAULT_VALUE)

  init {
    viewModelScope.launch {
      val prevTask = getTaskAtPositionUseCase(taskPosition) ?: return@launch
      task.value = prevTask.toUIModel()
    }
  }

  override fun getTask(): Flow<TaskEditorModel> = task

  override fun setName(name: String) {
    task.value = task.value.copy(name = name)
  }

  override fun setDuration(duration: Long) {
    task.value = task.value.copy(duration = duration)
  }

  override fun taskIsValid(): Boolean {
    task.value.apply {
      if (name.isBlank()) return false
      if (duration == 0L) return false
      return true
    }
  }

  override fun save() {
    viewModelScope.launch {
      setTaskAtPositionUseCase(taskPosition, task.value.toDomainModel())
    }
  }

}