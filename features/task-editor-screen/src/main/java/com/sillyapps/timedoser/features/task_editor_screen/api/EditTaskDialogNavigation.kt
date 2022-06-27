package com.sillyapps.timedoser.features.task_editor_screen.api

import androidx.compose.runtime.Composable
import com.sillyapps.core.ui.daggerViewModel
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.di.DayComponent
import com.sillyapps.timedoser.features.task_editor_screen.di.DaggerTaskEditorScreenComponent
import com.sillyapps.timedoser.features.task_editor_screen.di.TaskPosition
import com.sillyapps.timedoser.features.task_editor_screen.models.TaskEditorModel
import com.sillyapps.timedoser.features.task_editor_screen.ui.TaskEditorDialogContent

@Composable
fun TaskEditorDialog(
  dayComponent: DayComponent,
  taskPosition: Int?,
  onDismiss: () -> Unit
) {
  val component = DaggerTaskEditorScreenComponent
    .builder()
    .dayComponent(dayComponent)
    .taskPosition(taskPosition ?: -1)
    .build()

  val viewModel = daggerViewModel {
    component.getViewModel()
  }

  TaskEditorDialogContent(
    onDismiss = onDismiss,
    stateHolder = viewModel
  )
}
