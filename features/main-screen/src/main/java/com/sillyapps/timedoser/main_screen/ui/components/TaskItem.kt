package com.sillyapps.timedoser.main_screen.ui.components

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.main_screen.model.TaskUIModel

@Composable
fun TaskItem(
  task: TaskUIModel
) {
  Surface {

  }
}

@Preview
@Composable
fun TaskItemPreview() {
  val task by remember {
    mutableStateOf(TaskUIModel(0, 0, 0, "Task"))
  }

  TimeDoserTheme {
    TaskItem(task)
  }
}