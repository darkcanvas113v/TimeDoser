package com.sillyapps.timedoser.main_screen.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.main_screen.model.TaskUIModel

@Composable
fun SuccessFragment(
  onItemClick: () -> Unit,
  tasks: List<TaskUIModel>
) {
  
  LazyColumn() {
    items(
      items = tasks
    ) { task ->
      TaskItem(task = task)
    }
  }
  
}